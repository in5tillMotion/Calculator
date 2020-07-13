import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG {

    @DataProvider
    public Object[][] testObjectsPositive(){
        return new Object[][] {
                {10, 3, '+', 13},
                {7, 6, '-', 1},
                {10, 3, '/', 3},
                {8, 7, '*', 56},

        };
    }

    @Test(dataProvider = "testObjectsPositive")
    public void calcTestPositive(int first, int second, char operation, int result){
        Assert.assertEquals(result, Calculator.calc(first, second, operation), "Значения не равны");
    }

    @DataProvider
    public Object[][] testObjectsWrong(){
        return new Object[][] {
                {7, 6, '+', 12},
                {333, 111, '-', 12},
                {90, 12, '/', 1},
                {4, 2, '*', 100}
        };
    }

    @Test(dataProvider = "testObjectsWrong")
    public void calcTestWrongResult(int first, int second, char operation, int result){
        Assert.assertNotEquals(result, Calculator.calc(first, second, operation), "Значения равны");
    }

    @DataProvider
    public Object[][] testObjectsEqual() {
        return new Object[][]  {
                {2147483647, 1, '+',-2147483648 },
                {-2147483648, 1, '-', 2147483647},
                {-1, -1, '-', 0 }

        };
    }

    @Test(dataProvider = "testObjectsEqual")
    public void calcTestEqualResult(int first, int second, char operation, int result) {
        Assert.assertEquals(result, Calculator.calc(first, second, operation), "Значения не равны");
    }

}