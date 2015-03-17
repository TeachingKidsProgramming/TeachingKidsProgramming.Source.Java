package org.teachingextensions.approvals.lite.util.io;

import java.io.File;
import java.util.*;

public class FileMonitor {
    private Timer timer;
    private Map<File, Long> files;
    private Set<FileListener> listeners;

    public FileMonitor(long pollingInterval) {
        files = new HashMap<>();
        listeners = new HashSet<>();
        timer = new Timer(true);
        timer.schedule(new FileMonitorNotifier(), 0, pollingInterval);
    }

    public void stop() {
        timer.cancel();
    }

    public void addFile(File file) {
        if (!files.containsKey(file)) {
            files.put(file, (file.exists() ? file.lastModified() : -1L));
        }
    }

    public void addListener(FileListener fileListener) {
        listeners.add(fileListener);
    }

    private class FileMonitorNotifier extends TimerTask {
        public void run() {
            for (File file : files.keySet()) {
                long lastModifiedTime;
                lastModifiedTime = files.get(file);
                long newModifiedTime = file.exists() ? file.lastModified() : -1;
                if (newModifiedTime != lastModifiedTime) {
                    files.put(file, newModifiedTime);
                    for (FileListener listener : listeners) {
                        listener.fileChanged(file);
                    }
                }
            }
        }
    }

    public interface FileListener {
        void fileChanged(File file);
    }
}
