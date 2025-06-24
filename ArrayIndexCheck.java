package Tasks;

public class ArrayIndexCheck {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30};

        try {
            System.out.println(nums[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index is out of bounds.");
        }
    }
}
