import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Test1 {
    public static void main(String[] args) {
        List<Examinee> examineeList = populateTestData();
        AtomicInteger index = new AtomicInteger(1);

        examineeList.stream()
                .filter(examinee -> examinee.getSubjectMarks().values().stream()
                        .noneMatch(mark -> mark<35f))
                .map(examinee -> new AbstractMap.SimpleEntry<>(examinee.getId(), examinee.getSubjectMarks().values().stream().reduce((a, b) -> a+b)))
                .sorted(Comparator.comparing(simpleEntry -> simpleEntry.getValue().get(),Comparator.reverseOrder()))
                .map(simpleEntry -> new AbstractMap.SimpleEntry<>(index.getAndIncrement(), simpleEntry.getKey()))
                .forEach(simpleEntry -> System.out.println(simpleEntry));
    }

    private static List<Examinee> populateTestData() {
        List<Examinee> examineeList = new ArrayList<>();

        //Test Data 1
        Map<String, Float> subjectMarks = new HashMap<>();
        subjectMarks.put("Physics", 87f);
        subjectMarks.put("Chemistry", 84f);
        subjectMarks.put("Maths", 36f);
        examineeList.add(new Examinee(1l, subjectMarks));

        //Test Data 2
        subjectMarks = new HashMap<>();
        subjectMarks.put("Physics", 46f);
        subjectMarks.put("Chemistry", 47f);
        subjectMarks.put("Maths", 26f);
        examineeList.add(new Examinee(2l, subjectMarks));

        //Test Data 3
        subjectMarks = new HashMap<>();
        subjectMarks.put("Physics", 64f);
        subjectMarks.put("Chemistry", 75f);
        subjectMarks.put("Maths", 46f);
        examineeList.add(new Examinee(3l, subjectMarks));

        //Test Data 4
        subjectMarks = new HashMap<>();
        subjectMarks.put("Physics", 89f);
        subjectMarks.put("Chemistry", 83f);
        subjectMarks.put("Maths", 94f);
        examineeList.add(new Examinee(4l, subjectMarks));

        return examineeList;
    }
}
class Examinee {
    private long id;
    private Map<String, Float> subjectMarks;

    public Examinee(long id, Map<String, Float> subjectMarks) {
        this.id = id;
        this.subjectMarks = subjectMarks;
    }

    public long getId() {
        return id;
    }

    public Map<String, Float> getSubjectMarks() {
        return subjectMarks;
    }

    @Override
    public String toString() {
        return "Examinee{id=" + id + ", subjectMarks=" + subjectMarks + "}";
    }
}
