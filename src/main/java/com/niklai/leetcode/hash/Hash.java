package com.niklai.leetcode.hash;

import com.niklai.leetcode.tree.binary.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Hash {

    /**
     * @param nums
     * @return
     * @see HashTest#singleNumberTest()
     */
    //    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //
    //    说明：
    //
    //    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //    示例 1:
    //
    //    输入: [2,2,1]
    //    输出: 1
    //
    //    示例 2:
    //
    //    输入: [4,1,2,1,2]
    //    输出: 4
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                set.remove(n);
            }
        }

        for (int n : set) {
            return n;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     * @see HashTest#intersectionTest()
     */
    //    给定两个数组，编写一个函数来计算它们的交集。
    //
    //
    //
    //    示例 1：
    //
    //    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //    输出：[2]
    //
    //    示例 2：
    //
    //    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //    输出：[9,4]
    //
    //
    //
    //    说明：
    //
    //    输出结果中的每个元素一定是唯一的。
    //    我们可以不考虑输出结果的顺序。
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<Integer>();
        for (int n : nums2) {
            set2.add(n);
        }

        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            if (!set2.contains(n)) {
                iterator.remove();
            }
        }

        return set1.stream().mapToInt(s -> s).toArray();
    }

    /**
     * @param n
     * @return
     * @see HashTest#isHappyTest()
     */
    //    编写一个算法来判断一个数 n 是不是快乐数。
    //
    //    「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    //
    //    如果 n 是快乐数就返回 True ；不是，则返回 False 。
    //
    //
    //
    //    示例：
    //
    //    输入：19
    //    输出：true
    //    解释：
    //            12 + 92 = 82
    //            82 + 22 = 68
    //            62 + 82 = 100
    //            12 + 02 + 02 = 1
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                int i = n % 10;
                sum += i * i;
                n = (n - i) / 10;
            }

            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            }

            set.add(sum);
            n = sum;
        }
    }

    /**
     * @param s
     * @param t
     * @return
     * @see HashTest#isIsomorphicTest()
     */
    //    给定两个字符串 s 和 t，判断它们是否是同构的。
    //
    //    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    //
    //    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    //
    //    示例 1:
    //
    //    输入: s = "egg", t = "add"
    //    输出: true
    //
    //    示例 2:
    //
    //    输入: s = "foo", t = "bar"
    //    输出: false
    //
    //    示例 3:
    //
    //    输入: s = "paper", t = "title"
    //    输出: true
    //
    //    说明:
    //    你可以假设 s 和 t 具有相同的长度。
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        return isIsomorphicItem(s1, s2) && isIsomorphicItem(s2, s1);
    }

    private static boolean isIsomorphicItem(char[] s, char[] t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], t[i]);
            } else {
                if (map.get(s[i]) != t[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @param list1
     * @param list2
     * @return
     * @see HashTest#findRestaurantTest()
     */
    //    假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
    //
    //    你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
    //
    //    示例 1:
    //
    //    输入:
    //            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //            ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    //    输出: ["Shogun"]
    //    解释: 他们唯一共同喜爱的餐厅是“Shogun”。
    //
    //    示例 2:
    //
    //    输入:
    //            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //            ["KFC", "Shogun", "Burger King"]
    //    输出: ["Shogun"]
    //    解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
    //
    //    提示:
    //
    //    两个列表的长度范围都在 [1, 1000]内。
    //    两个列表中的字符串的长度将在[1，30]的范围内。
    //    下标从0开始，到列表的长度减1。
    //    两个列表都没有重复的元素。
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        if (map1.size() < map2.size()) {
            for (Map.Entry<String, Integer> item : map1.entrySet()) {
                if (map2.containsKey(item.getKey())) {
                    int r = item.getValue() + map2.get(item.getKey());
                    if (r == min) {
                        list.add(item.getKey());
                    } else if (r < min) {
                        min = r;
                        list.clear();
                        list.add(item.getKey());
                    }
                }
            }
        } else {
            for (Map.Entry<String, Integer> item : map2.entrySet()) {
                if (map1.containsKey(item.getKey())) {
                    int r = item.getValue() + map1.get(item.getKey());
                    if (r == min) {
                        list.add(item.getKey());
                    } else if (r < min) {
                        min = r;
                        list.clear();
                        list.add(item.getKey());
                    }
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }

    //    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //
    //    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //
    //
    //
    //    示例:
    //
    //    给定 nums = [2, 7, 11, 15], target = 9
    //
    //    因为 nums[0] + nums[1] = 2 + 7 = 9
    //    所以返回 [0, 1]
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xhb0fv/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param nums
     * @param target
     * @return
     * @see HashTest#twoSumTest()
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r)) {
                return new int[]{map.get(r), i};
            }

            map.put(nums[i], i);
        }
        return new int[0];
    }

    //    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    //
    //
    //
    //    示例：
    //
    //    s = "leetcode"
    //    返回 0
    //
    //    s = "loveleetcode"
    //    返回 2
    //
    //
    //
    //    提示：你可以假定该字符串只包含小写字母。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxx94s/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param leel
     * @return
     * @see HashTest#firstUniqCharTest()
     */
    public static int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])) {
                return i;
            }
        }

        return -1;
    }

    //    给定两个数组，编写一个函数来计算它们的交集。
    //
    //
    //
    //    示例 1：
    //
    //    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //    输出：[2,2]
    //
    //    示例 2:
    //
    //    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //    输出：[4,9]
    //
    //
    //
    //    说明：
    //
    //    输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    //    我们可以不考虑输出结果的顺序。
    //
    //    进阶：
    //
    //    如果给定的数组已经排好序呢？你将如何优化你的算法？
    //    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    //    如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xx5hsd/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param nums1
     * @param nums2
     * @return
     * @see HashTest#intersectTest()
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] base = null;
        int[] target = null;
        if (nums1.length < nums2.length) {
            base = nums1;
            target = nums2;
        } else {
            base = nums2;
            target = nums1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : base) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int n : target) {
            if (map.containsKey(n) && map.get(n) != 0) {
                result.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] n = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            n[i] = result.get(i);
        }

        return n;
    }

    //    给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
    //
    //
    //
    //    示例 1:
    //
    //    输入: nums = [1,2,3,1], k = 3
    //    输出: true
    //
    //    示例 2:
    //
    //    输入: nums = [1,0,1,1], k = 1
    //    输出: true
    //
    //    示例 3:
    //
    //    输入: nums = [1,2,3,1,2,3], k = 2
    //    输出: false
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xx5bzh/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param nums
     * @param k
     * @return
     * @see HashTest#containsNearbyDuplicateTest()
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    //    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    //
    //    示例:
    //
    //    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    //    输出:
    //            [
    //            ["ate","eat","tea"],
    //            ["nat","tan"],
    //            ["bat"]
    //            ]
    //
    //    说明：
    //
    //    所有输入均为小写字母。
    //    不考虑答案输出的顺序。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxo631/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param strs
     * @return
     * @see HashTest#groupAnagramsTest()
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] k = str.toCharArray();
            Arrays.sort(k);
            StringBuffer sb = new StringBuffer();
            for (char c : k) {
                sb.append(c);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());

            }
            map.get(key).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    //    给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
    //
    //            "abc" -> "bcd" -> ... -> "xyz"
    //
    //    给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
    //
    //
    //
    //    示例：
    //
    //    输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
    //    输出：
    //            [
    //            ["abc","bcd","xyz"],
    //            ["az","ba"],
    //            ["acef"],
    //            ["a","z"]
    //            ]
    //    解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxr887/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param strings
     * @return
     * @see HashTest#groupStringsTest()
     */
    public static List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            if (str.length() == 1) {
                addToMap("a", str, map);
            } else {
                Map<String, String> trans = trans(str.toCharArray());
                trans.forEach((k, v) -> {
                    addToMap(k, v, map);
                });
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }

    private static void addToMap(String key, String value, Map<String, List<String>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(value);
    }

    private static Map<String, String> trans(char[] chars) {
        HashMap<String, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        int dValue = chars[0] - 97;
        sb.append('a');
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            int d = c - 97;
            if (d < dValue) {
                sb.append((char) (123 - (dValue - d)));
            } else {
                sb.append((char) (c - dValue));
            }
        }

        map.put(sb.toString(), new StringBuffer().append(chars, 0, chars.length).toString());
        return map;
    }

    //    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //
    //    数字 1-9 在每一行只能出现一次。
    //    数字 1-9 在每一列只能出现一次。
    //    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    //
    //    上图是一个部分填充的有效的数独。
    //
    //    数独部分空格内已填入了数字，空白格用 '.' 表示。
    //
    //    示例 1:
    //
    //    输入:
    //            [
    //            ["5","3",".",".","7",".",".",".","."],
    //            ["6",".",".","1","9","5",".",".","."],
    //            [".","9","8",".",".",".",".","6","."],
    //            ["8",".",".",".","6",".",".",".","3"],
    //            ["4",".",".","8",".","3",".",".","1"],
    //            ["7",".",".",".","2",".",".",".","6"],
    //            [".","6",".",".",".",".","2","8","."],
    //            [".",".",".","4","1","9",".",".","5"],
    //            [".",".",".",".","8",".",".","7","9"]
    //            ]
    //    输出: true
    //
    //    示例 2:
    //
    //    输入:
    //            [
    //            ["8","3",".",".","7",".",".",".","."],
    //            ["6",".",".","1","9","5",".",".","."],
    //            [".","9","8",".",".",".",".","6","."],
    //            ["8",".",".",".","6",".",".",".","3"],
    //            ["4",".",".","8",".","3",".",".","1"],
    //            ["7",".",".",".","2",".",".",".","6"],
    //            [".","6",".",".",".",".","2","8","."],
    //            [".",".",".","4","1","9",".",".","5"],
    //            [".",".",".",".","8",".",".","7","9"]
    //            ]
    //    输出: false
    //    解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
    //    但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
    //
    //    说明:
    //
    //    一个有效的数独（部分已被填充）不一定是可解的。
    //    只需要根据以上规则，验证已经填入的数字是否有效即可。
    //    给定数独序列只包含数字 1-9 和字符 '.' 。
    //    给定数独永远是 9x9 形式的。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxpit5/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param s1
     * @return
     * @see HashTest#isValidSudokuTest()
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                if (set.contains(t)) {
                    return false;
                }
                set.add(t);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                if (set.contains(t)) {
                    return false;
                }
                set.add(t);
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidSudoKuItem(board, i, i + 2, j, j + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoKuItem(char[][] board,
                                             int rowStartIndex, int rowEndIndex,
                                             int colStartIndex, int colEndIndex) {
        HashSet<Character> set = new HashSet<>();
        for (int i = rowStartIndex; i <= rowEndIndex; i++) {
            for (int j = colStartIndex; j <= colEndIndex; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                if (set.contains(t)) {
                    return false;
                }
                set.add(t);
            }
        }
        return true;
    }

    //    给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
    //
    //    两棵树重复是指它们具有相同的结构以及相同的结点值。
    //
    //    示例 1：
    //
    //            1
    //           / \
    //          2   3
    //         /   / \
    //        4   2   4
    //           /
    //          4
    //
    //    下面是两个重复的子树：
    //
    //            2
    //           /
    //          4
    //
    //    和
    //
    //    4
    //
    //    因此，你需要以列表的形式返回上述重复子树的根结点。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxm0i6/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param root
     * @return
     * @see HashTest#findDuplicateSubtreesTest()
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        findDuplicateSubtrees0(root, set, list);
        return list;
    }

    private static void findDuplicateSubtrees0(TreeNode node, Set<String> set, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        String key = node.val + ";" + (node.left != null ? node.left.val : "") + ";" + (node.right != null ? node.right.val : "");
        if (set.contains(key) && list.stream().filter(n -> n.val == node.val).count() == 0) {
            list.add(node);
        } else {
            set.add(key);
        }
        findDuplicateSubtrees0(node.left, set, list);
        findDuplicateSubtrees0(node.right, set, list);
    }

    //    给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    //
    //    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
    //
    //    示例 1:
    //
    //    输入: J = "aA", S = "aAAbbbb"
    //    输出: 3
    //
    //    示例 2:
    //
    //    输入: J = "z", S = "ZZ"
    //    输出: 0
    //
    //    注意:
    //
    //    S 和 J 最多含有50个字母。
    //    J 中的字符不重复。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xx2a0c/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param aA
     * @param aAAbbbb
     * @return
     * @see HashTest#numJewelsInStonesTest()
     */
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> jSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jSet.add(c);
        }

        int r = 0;
        for (char c : S.toCharArray()) {
            if (jSet.contains(c)) {
                r++;
            }
        }

        return r;
    }

    //    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    //
    //
    //    示例 1:
    //
    //    输入: s = "abcabcbb"
    //    输出: 3
    //    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //
    //    示例 2:
    //
    //    输入: s = "bbbbb"
    //    输出: 1
    //    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //
    //    示例 3:
    //
    //    输入: s = "pwwkew"
    //    输出: 3
    //    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //
    //    示例 4:
    //
    //    输入: s = ""
    //    输出: 0
    //
    //
    //
    //    提示：
    //
    //            0 <= s.length <= 5 * 104
    //    s 由英文字母、数字、符号和空格组成
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxnrdi/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param abcabcbb
     * @return
     * @see HashTest#lengthOfLongestSubstringTest()
     */
    public static int lengthOfLongestSubstring(String s) {
        int r = 0;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    if (next != c) {
                        iterator.remove();
                    } else {
                        iterator.remove();
                        break;
                    }
                }
            }

            set.add(c);
            r = Math.max(r, set.size());
        }

        return r;
    }

    //    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
    //
    //    为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
    //
    //    例如:
    //
    //    输入:
    //    A = [ 1, 2]
    //    B = [-2,-1]
    //    C = [-1, 2]
    //    D = [ 0, 2]
    //
    //    输出:
    //            2
    //
    //    解释:
    //    两个元组如下:
    //            1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    //            2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxwhng/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     * @see HashTest#fourSumCountTest()
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        int length = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int r = A[i] + B[j];
                if (!map.containsKey(r)) {
                    map.put(r, 1);
                } else {
                    map.put(r, map.get(r) + 1);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int r = 0 - (C[i] + D[j]);
                if (map.containsKey(r)) {
                    result += map.get(r);
                }
            }
        }
        return result;
    }

    //    请你设计一个日志系统，可以流式接收日志以及它的时间戳。
    //
    //    该日志会被打印出来，需要满足一个条件：当且仅当日志内容 在过去的 10 秒钟内没有被打印过。
    //
    //    给你一条日志的内容和它的时间戳（粒度为秒级），如果这条日志在给定的时间戳应该被打印出来，则返回 true，否则请返回 false。
    //
    //    要注意的是，可能会有多条日志在同一时间被系统接收。
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xx91k3/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    static class Logger {
        private Map<String, Integer> messeages;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            messeages = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        /**
         * @param timestamp
         * @param message
         * @return
         * @see HashTest#logShouldPrintMessageTest()
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!messeages.containsKey(message)) {
                messeages.put(message, timestamp);
                return true;
            }

            if (timestamp - messeages.get(message) >= 10) {
                messeages.put(message, timestamp);
                return true;
            }

            return false;
        }
    }

    //    设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
    //
    //    实现 TwoSum 类：
    //
    //    TwoSum() 使用空数组初始化 TwoSum 对象
    //    void add(int number) 向数据结构添加一个数 number
    //    boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
    //
    //
    //
    //    示例：
    //
    //    输入：
    //            ["TwoSum", "add", "add", "add", "find", "find"]
    //            [[], [1], [3], [5], [4], [7]]
    //    输出：
    //            [null, null, null, null, true, false]
    //
    //    解释：
    //    TwoSum twoSum = new TwoSum();
    //    twoSum.add(1);   // [] --> [1]
    //    twoSum.add(3);   // [1] --> [1,3]
    //    twoSum.add(5);   // [1,3] --> [1,3,5]
    //    twoSum.find(4);  // 1 + 3 = 4，返回 true
    //    twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false
    //
    //
    //
    //    提示：
    //
    //            -10的5次方 <= number <= 10的5次方
    //            -2的31次方 <= value <= 2的31次方 - 1
    //    最多调用 5 * 104 次 add 和 find
    //
    //    作者：力扣 (LeetCode)
    //    链接：https://leetcode-cn.com/leetbook/read/hash-table/xxv9we/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @see HashTest#twoSumClassTest()
     */
    static class TwoSum {
        private Map<Integer, Integer> nums = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            if (nums.containsKey(number)) {
                nums.put(number, nums.get(number) + 1);
            } else {
                nums.put(number, 1);
            }
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
                int n = value - entry.getKey();
                if (n == entry.getKey()) {
                    if (entry.getValue() > 1) {
                        return true;
                    }
                } else if (nums.containsKey(n)) {
                    return true;
                }
            }

            return false;
        }
    }
}
