package com.lacunasoftware.restpki;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.threeten.bp.OffsetDateTime;

import java.awt.*;
import java.awt.image.ColorModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Util {

	// region String

	static String repeatChar(char c, int count) {
		char[] array = new char[count];
		Arrays.fill(array, c);
		return new String(array);
	}

	static String join(String delimiter, List<String> elements) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.size(); i++) {
			sb.append(elements.get(i));
			if (i < elements.size() -1) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	static boolean isNullOrEmpty(String s) {
		return (s == null || s.isEmpty());
	}

	// endregion

	static byte[] readStream(InputStream stream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];
		while ((nRead = stream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		return buffer.toByteArray();
	}

	static byte[] decodeBase64(String s) {
		return new ObjectMapper().convertValue(s, byte[].class);
	}

	static String encodeBase64(byte[] content) {
		return new ObjectMapper().convertValue(content, String.class);
	}

	static Date parseApiDate(OffsetDateTime dateStr) {
		Date date;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		try {
			date = fmt.parse(dateStr.toString());
		} catch (ParseException ex) {
			date = null;
		}
		return date;
	}


//	public static String joinStrings(String separator, Collection<String> parts) {
//		StringBuilder text = new StringBuilder();
//		for (String part : parts) {
//			if (text.length() > 0) {
//				text.append(separator);
//			}
//			text.append(part);
//		}
//		return parts.toString();
//	}

//	public static <F, T> List<T> convertAll(Collection<F> from, Function<F, T> transformer) {
//		List<T> to = new ArrayList<T>();
//		for (F item : from) {
//			to.add(transformer.apply(item));
//		}
//		return to;
//	}

//	public static void appendRepeating(StringBuilder sb, char c, int count) {
//		for (int i = 0; i < count; i++) {
//			sb.append(c);
//		}
//	}

}
