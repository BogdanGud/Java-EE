import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.gojava.calculatorlib.*;

import java.util.List;

public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");

        IntegerParser integerParser = (IntegerParser) context.getBean("integerParser");
        DoubleParser doubleParser  = (DoubleParser) context.getBean("doubleParser");

        PolishMathParser intStatementParser = new PolishMathParser<Integer>(integerParser);
        PolishMathParser doubleStatementParser = new PolishMathParser<Double>(doubleParser);

        intStatementParser.registerOperator("+", new IntegerAdditionOperator());
        intStatementParser.registerOperator("-", new IntegerSubstractionOperator());
        intStatementParser.registerOperator("*", new IntegerMultiplyOperator());

        doubleStatementParser.registerOperator("+", new DoubleAdditionOperator());
        doubleStatementParser.registerOperator("-", new DoubleSubstractionOperator());
        doubleStatementParser.registerOperator("*", new DoubleMultiplyOperator());

        System.out.println("Integer calculating: ");
        System.out.println(intStatementParser.calculate("23 32 +"));
        System.out.println(intStatementParser.calculate("79 45 -"));
        System.out.println(intStatementParser.calculate("150 20 *"));

        System.out.println("Double calculating: ");
        System.out.println(doubleStatementParser.calculate("2.3 3.2 +"));
        System.out.println(doubleStatementParser.calculate("57.9 20.46 -"));
        System.out.println(doubleStatementParser.calculate("23.54 32.6 * "));

    }

}
