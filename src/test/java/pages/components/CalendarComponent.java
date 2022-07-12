package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String month, String year ){
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $("[aria-label$='" + month + " " + day + "th, " + year + " ' ]").click();
    }
}
