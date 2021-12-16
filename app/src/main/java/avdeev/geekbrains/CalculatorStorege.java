package avdeev.geekbrains;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CalculatorStorege implements Parcelable {

    private ArrayList<String> listMembers;

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
        listMembers.add(member);
    }

    public String getResultText() {
        String result = "";
        for (String str: listMembers) {
            result += str;
        }
        return result;
    }

}
