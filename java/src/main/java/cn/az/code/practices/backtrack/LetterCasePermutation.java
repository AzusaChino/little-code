package cn.az.code.practices.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 3/10/2020 08:46
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }
}
