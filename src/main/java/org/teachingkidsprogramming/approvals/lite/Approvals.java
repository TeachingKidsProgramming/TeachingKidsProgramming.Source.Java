package org.teachingkidsprogramming.approvals.lite;

import org.teachingkidsprogramming.approvals.lite.ReporterFactory.FileTypes;
import org.teachingkidsprogramming.approvals.lite.namer.ApprovalNamer;
import org.teachingkidsprogramming.approvals.lite.namer.JUnitStackTraceNamer;
import org.approvaltests.writers.ApprovalTextWriter;
import org.approvaltests.writers.ImageApprovalWriter;
import org.lambda.functions.Function1;
import org.teachingkidsprogramming.util.ArrayUtils;
import org.teachingkidsprogramming.util.ObjectUtils;
import org.teachingkidsprogramming.util.StringUtils;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Approvals {
	public static void verify(String response) throws Exception {
		verify(new ApprovalTextWriter(response, "txt"), FileTypes.Text);
	}

    public static <T> void verifyAll(String header, T[] values,
			Function1<T, String> f1) {
		verifyAll(header, Arrays.asList(values), f1);
	}

	public static <T> void verifyAll(String header, Iterable<T> array,
			Function1<T, String> f1) {
		String text = formatHeader(header) + ArrayUtils.toString(array, f1);
		verify(new ApprovalTextWriter(text, "txt"), FileTypes.Text);
	}

	private static String formatHeader(String header) {
		return StringUtils.isEmpty(header) ? "" : header + "\r\n\r\n\r\n";
	}

    public static void verifyHtml(String response) throws Exception {
		verify(new ApprovalTextWriter(response, "html"), FileTypes.Html);
	}

    public static void verify(BufferedImage bufferedImage) {
		verify(new ImageApprovalWriter(bufferedImage), FileTypes.Image);
	}

	public static void verify(ApprovalWriter writter, ApprovalNamer namer,
			ApprovalFailureReporter reporter) {
		verify(new FileApprover(writter, namer), reporter);
	}

	public static void verify(ApprovalWriter writter, String fileType) {
		verify(writter, createApprovalNamer(), ReporterFactory.get(fileType));
	}

    public static void verify(FileApprover approver,
			ApprovalFailureReporter reporter) {
		try {
			if (!approver.approve()) {
				boolean passed = false;
				if (reporter instanceof ApprovalFailureOverrider) {
					passed = approver
							.askToChangeReceivedToApproved((ApprovalFailureOverrider) reporter);
				}
				if (!passed) {
					approver.reportFailure(reporter);
					approver.fail();
				} else {
					approver.cleanUpAfterSuccess(reporter);
				}
			} else {
				approver.cleanUpAfterSuccess(reporter);
			}
		} catch (Exception e) {
			throw ObjectUtils.throwAsError(e);
		}
	}

    public static ApprovalNamer createApprovalNamer() {
		return new JUnitStackTraceNamer();
	}

}