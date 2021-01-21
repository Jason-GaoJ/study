package leetcode;

import java.time.LocalDateTime;

/**
 * @author Jason
 * @date 2019/11/26 16:53
 * @description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().getDayOfWeek().getValue());

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result=null;
        for (int i = 0; i < lists.length; i++) {

        }
        return result;
    }

}
