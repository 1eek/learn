package _2石头剪刀布游戏;

import java.util.Random;
public class ComputerOperation {

    // 创建三个按钮，即"我出剪刀"、"我出石头"、"我出布"
    private String statement = "本游戏解释权为";
    private String statementName = "@zhangxiaobin";
    private String yourScissor = "我出剪刀";
    private String yourStone = "我出石头";
    private String yourCloth = "我出布";

    // computerScissor、computerStone 、computerCloth是电脑随机出的手型
    private String computerScissor = "电脑出剪刀";
    private String computerStone = "电脑出石头";
    private String computerCloth = "电脑出布";

    // 返回声明人姓名和声明
    public String getStatementName() {
        return statementName;
    }
    public String getStatement(){
        return statement;
    }

    // 返回computerScissor、computerCloth、computerStone的值
    public String getComputerScissor() {
        return computerScissor;
    }
    public String getComputerStone() {
        return computerStone;
    }
    public String getComputerCloth() {
        return computerCloth;
    }

    // 返回yourScissor、yourStone、yourCloth
    public String getYourScissor() {
        return yourScissor;
    }
    public String getYourStone() {
        return yourStone;
    }
    public String getYourCloth() {
        return yourCloth;
    }

    // 判断是电脑出随机出的手型否是和“电脑出剪刀”相同;
    public Boolean judgeWithScissor() throws ExceptionTest {
        if ( ComputerOutFinger().equals(getComputerScissor()) )
            return true;
        else
            return false;
    }

    // 判断是电脑出随机出的手型否是和“电脑出石头”相同;
    public Boolean judgeWithStone() throws ExceptionTest{
        if ( ComputerOutFinger().equals(getComputerStone()) )
            return true;
        else
            return false;
    }

    // 电脑随机生成0、1、2，如果是1电脑就出剪刀，2电脑出石头，3电脑出布
    Random r = new Random();
    public String ComputerOutFinger() throws ExceptionTest{
        switch (r.nextInt(3)) {
            case 0:
                return (computerScissor);
            case 1:
                return (computerStone);
            case 2:
                return (computerCloth);
            default:
                throw new ExceptionTest("超出范围");
        }
    }
}