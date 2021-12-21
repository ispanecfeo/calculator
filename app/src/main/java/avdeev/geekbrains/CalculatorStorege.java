package avdeev.geekbrains;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CalculatorStorege implements Parcelable {

    private ArrayList<String> listMembers;
    private int countOperators = 0;

    public CalculatorStorege() {
        listMembers = new ArrayList<>();
    }

    protected CalculatorStorege(Parcel in) {
        this.listMembers = in.readArrayList(String.class.getClassLoader());
    }

    public static final Creator<CalculatorStorege> CREATOR = new Creator<CalculatorStorege>() {
        @Override
        public CalculatorStorege createFromParcel(Parcel in) {
            return new CalculatorStorege(in);
        }

        @Override
        public CalculatorStorege[] newArray(int size) {
            return new CalculatorStorege[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(listMembers);
    }

    public void addMember(String member) {

        if (isOperator(member)) {
            countOperators++;
        }

        if (member.equals("=") || countOperators == 2)  {

            String p1 = "";
            String p2 = "";
            String operator = "";
            boolean firstParametr = true;

            for (String str: listMembers) {

                if (isOperator(str)) {
                    operator = str;
                    firstParametr = false;
                    continue;
                }

                if (firstParametr) {
                    p1 += str;
                } else {
                    p2 += str;
                }
            }

            String result = runСalculate(
                    Integer.parseInt(p1),
                    Integer.parseInt(p2),
                    operator
            );

            if (!member.equals("=")) {
                listMembers.add("=");
            } else {
                listMembers.add(member);
            }

            listMembers.add(result);
            countOperators++;

        } else if (countOperators == 3) {

            listMembers.clear();
            countOperators = 0;
            listMembers.add(member);

        } else {
            listMembers.add(member);
        }
    }

    public String getResultText() {
        String result = "";
        for (String str: listMembers) {
            result += str;
        }
        return result;
    }

    private String runСalculate(int p1, int p2, String operation) {
        int result = 0;
        switch (operation) {
            case "+" :  result = p1 + p2;
                break;
            case "-" :  result = p1 - p2;
                break;
            case "*" :  result = p1 * p2;
                break;
            case "/" :  result = p1 / p2;
                break;
            default:
                break;
        }
        return  String.valueOf(result);

    }

    private boolean isOperator(String member) {
        switch (member) {
            case "+" :
            case "-" :
            case "*" :
            case "/" :
            case "=" :
                return true;
            default:
                break;
        }
        return false;
    }

}
