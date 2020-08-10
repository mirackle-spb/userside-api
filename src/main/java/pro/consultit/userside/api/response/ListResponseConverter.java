package pro.consultit.userside.api.response;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListResponseConverter extends StdConverter<String, List<Integer>> {
	@Override
	public List<Integer> convert(final String string) {
		var processString = string.trim();
		if (processString.length() > 0) {
			if (processString.contains(",")) {
				return Stream.of(processString.split(",")).map(String::trim)
				             .map(Integer::parseInt).collect(Collectors.toList());
			} else {
				return Collections.singletonList(Integer.parseInt(processString));
			}
		} else {
			return new ArrayList<>();
		}
	}
}
