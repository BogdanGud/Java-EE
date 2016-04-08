import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TestExporter {

    public void reportToCsv(String sFileName, TestResult testResult10k, TestResult testResult100k,
                            TestResult testResult1000k) {
        try {
            FileWriter writer = new FileWriter(sFileName);

            writer.append("Result for 10K");
            writer.append('\n');
            writer.append('\n');
            printHeader(writer);
            writeTestResult(testResult10k, writer);

            writer.append("Result for 100K");
            writer.append('\n');
            writer.append('\n');
            printHeader(writer);
            writeTestResult(testResult100k, writer);

            writer.append("Result for 1000K");
            writer.append('\n');
            writer.append('\n');
            printHeader(writer);
            writeTestResult(testResult1000k, writer);


            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTestResult(TestResult testResult, FileWriter writer) {
        prepareString(writer, "arrayList", testResult.arrayListResult);
        prepareString(writer, "linkedList", testResult.linkedListResult);
        prepareString(writer, "hashSet", testResult.hashSetResult);
        prepareString(writer, "treeSet", testResult.treeSettResult);
    }

    private void prepareString(FileWriter writer, String title, ArrayList<Long> collection) {
        try {
            writer.append(title + ",");
            for (int i = 0; i < collection.size(); i++) {
                writer.append(collection.get(i).toString() + ",");
            }
            writer.append('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void printHeader(FileWriter writer) {
        try {
            writer.append("Collection");
            writer.append(',');
            writer.append("add");
            writer.append(',');
            writer.append("get");
            writer.append(',');
            writer.append("remove");
            writer.append(',');
            writer.append("contains");
            writer.append(',');
            writer.append("populate");
            writer.append(',');
            writer.append("iterator.add");
            writer.append(',');
            writer.append("iterator.remove");
            writer.append('\n');
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
