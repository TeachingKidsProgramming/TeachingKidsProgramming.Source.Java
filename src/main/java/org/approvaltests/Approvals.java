package org.approvaltests;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Map;

import org.approvaltests.ReporterFactory.FileTypes;
import org.approvaltests.approvers.FileApprover;
import org.approvaltests.core.ApprovalFailureOverrider;
import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.core.ApprovalWriter;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.namer.JUnitStackTraceNamer;
import org.approvaltests.writers.ApprovalTextWriter;
import org.approvaltests.writers.ApprovalXmlWriter;
import org.approvaltests.writers.ComponentApprovalWriter;
import org.approvaltests.writers.FileApprovalWriter;
import org.approvaltests.writers.ImageApprovalWriter;
import org.lambda.functions.Function1;

import org.teachingkidsprogramming.util.ArrayUtils;
import org.teachingkidsprogramming.util.ObjectUtils;
import com.spun.util.StringUtils;

public class Approvals {
	public static void verify(String response) throws Exception {
		verify(new ApprovalTextWriter(response, "txt"), FileTypes.Text);
	}

	public static void verify(Object o) throws Exception {
		verify("" + o);
	}

	public static <T> void verifyAll(String label, T[] array) throws Exception {
		verify(new ApprovalTextWriter(StringUtils.toString(label, array), "txt"),
				FileTypes.Text);
	}

	public static <T> void verifyAll(String header, String label, T[] array)
			throws Exception {
		verify(new ApprovalTextWriter(formatHeader(header)
				+ StringUtils.toString(label, array), "txt"), FileTypes.Text);
	}

	public static <T> void verifyAll(T[] values, Function1<T, String> f1) {
		String text = ArrayUtils.toString(values, f1);
		verify(new ApprovalTextWriter(text, "txt"), FileTypes.Text);
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

	public static <T> void verifyAll(String label, Iterable<T> array)
			throws Exception {
		verify(new ApprovalTextWriter(StringUtils.toString(label, array), "txt"),
				FileTypes.Text);
	}

	public static <T> void verifyAll(String header, String label,
			Iterable<T> array) throws Exception {
		verify(new ApprovalTextWriter(formatHeader(header)
				+ StringUtils.toString(label, array), "txt"), FileTypes.Text);
	}

	public static void verify(Component c) throws Exception {
		verify(new ComponentApprovalWriter(c), FileTypes.Image);
	}

	public static void verifyHtml(String response) throws Exception {
		verify(new ApprovalTextWriter(response, "html"), FileTypes.Html);
	}

	public static void verify(File generateFile) {
		verify(new FileApprovalWriter(generateFile), FileTypes.File);
	}

	public static void verify(Image image) {
		// approve(ImageWriter.toBufferedImage(image), createApprovalNamer());
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

	public static void verifyXml(String xml) throws Exception {
		verify(new ApprovalXmlWriter(xml), FileTypes.Text);
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

	public static void verify(Map map) throws Exception {
		verify(new ApprovalTextWriter(StringUtils.toString(map), "txt"),
				FileTypes.Text);
	}

	public static ApprovalNamer createApprovalNamer() {
		return new JUnitStackTraceNamer();
	}

	private static void approve(BufferedImage bufferedImage, ApprovalNamer namer) {
		verify(new ImageApprovalWriter(bufferedImage), FileTypes.Image);
	}

//	private static String getFileNameList(List<File> mismatched) {
//		return Query.select(mismatched,
//				new F1<File, String>(mismatched.get(1)) {
//					{
//						ret(a.getName());
//					}
//				}).toString();
//	}
}