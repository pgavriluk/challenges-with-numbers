package pavel.demo.meeting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Main.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}

	}

	private static List<Meeting> mergeRanges(List<Meeting> meetings) {

		List<Meeting> finalMeetingsRanges = new ArrayList<>();
		finalMeetingsRanges.add(meetings.get(0));


		for (int i = 1; i < meetings.size(); i++) {

			Meeting currentMeeting = new Meeting(meetings.get(i).getStartTime(), meetings.get(i).getEndTime());
			boolean createNew = true;

			for (Meeting existingMeeting: finalMeetingsRanges) {
				if(currentMeeting.getStartTime() >= existingMeeting.getStartTime() && currentMeeting.getStartTime() < existingMeeting.getEndTime()){
					existingMeeting.setEndTime(currentMeeting.getEndTime()>existingMeeting.getEndTime()? currentMeeting.getEndTime() : existingMeeting.getEndTime());
					createNew = false;
				}else if(currentMeeting.getStartTime() <= existingMeeting.getStartTime() && currentMeeting.getEndTime() >= existingMeeting.getStartTime()){
					existingMeeting.setStartTime(currentMeeting.getStartTime());
					createNew = false;
					if(currentMeeting.getEndTime() > existingMeeting.getEndTime()){
						existingMeeting.setEndTime(currentMeeting.getEndTime());
						createNew = false;
					}
				}else if(currentMeeting.getEndTime() > existingMeeting.getEndTime() && currentMeeting.getStartTime() <= existingMeeting.getEndTime()){
					existingMeeting.setEndTime(currentMeeting.getEndTime());
					createNew = false;
				}
			}
			if(createNew){
				finalMeetingsRanges.add(currentMeeting);
			}
		}

		finalMeetingsRanges.sort(Comparator.comparing(Meeting::getStartTime));
		return finalMeetingsRanges;

	}


	@Test
	public void meetingsOverlapTest() {
		final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(2, 4));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Collections.singletonList(new Meeting(1, 4));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsTouchTest() {
		final List<Meeting> meetings = Arrays.asList(new Meeting(5, 6), new Meeting(6, 8));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Collections.singletonList(new Meeting(5, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingContainsOtherMeetingTest() {
		final List<Meeting> meetings = Arrays.asList(new Meeting(1, 8), new Meeting(2, 5));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Collections.singletonList(new Meeting(1, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsStaySeparateTest() {
		final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(4, 8));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Arrays.asList(
				new Meeting(1, 3), new Meeting(4, 8)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void multipleMergedMeetingsTest() {
		final List<Meeting> meetings = Arrays.asList(
				new Meeting(1, 4), new Meeting(2, 5), new Meeting(5, 8));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Collections.singletonList(new Meeting(1, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsNotSortedTest() {
		final List<Meeting> meetings = Arrays.asList(
				new Meeting(5, 8), new Meeting(1, 4), new Meeting(6, 8));
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Arrays.asList(
				new Meeting(1, 4), new Meeting(5, 8)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void oneLongMeetingContainsSmallerMeetingsTest() {
		final List<Meeting> meetings = Arrays.asList(
				new Meeting(1, 10), new Meeting(2, 5), new Meeting(6, 8),
				new Meeting(9, 10), new Meeting(10, 12)
		);
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Collections.singletonList(new Meeting(1, 12)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void sampleInputTest() {
		final List<Meeting> meetings = Arrays.asList(
				new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8),
				new Meeting(10, 12), new Meeting(9, 10)
		);
		final List<Meeting> actual = mergeRanges(meetings);
		final List<Meeting> expected = Arrays.asList(
				new Meeting(0, 1), new Meeting(3, 8), new Meeting(9, 12)
		);
		assertEquals(expected, actual);
	}

}
