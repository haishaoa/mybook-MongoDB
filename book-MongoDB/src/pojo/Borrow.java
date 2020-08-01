package pojo;

/**
 * @author haishao
 * @create 2020-05-20 10:26
 * @discript :
 */
public class Borrow {
    private int number;
    private String readername;
    private String bookname;
    private String borrowtime;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    @Override
    public String toString() {
        return "BorrowServlet{" +
                "number=" + number +
                ", readername='" + readername + '\'' +
                ", bookname='" + bookname + '\'' +
                ", borrowtime='" + borrowtime + '\'' +
                '}';
    }
}
