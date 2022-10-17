//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成
//了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 
//是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。 
//
// 在结果列表中，选择 字典序最小 的名字作为真实名字。 
//
// 
//
// 示例： 
//
// 
//输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], 
//synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//输出：["John(27)","Chris(36)"] 
//
// 
//
// 提示： 
//
// 
// names.length <= 100000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 计数 👍 57 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class BabyNamesLcci {
    public static void main(String[] args) {
        Solution solution = new BabyNamesLcci().new Solution();
        String[] names = new String[] {"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"};
        String[] synonyms = new String[] {"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"};
        System.out.println(Arrays.toString(solution.trulyMostPopular(names, synonyms)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            Map<String, Integer> nameIndexMap = new HashMap<>();
            int index = 0;
            for (String nameFrequency : names) {
                int i = nameFrequency.indexOf('(');
                String name = nameFrequency.substring(0, i);

                if (!nameIndexMap.containsKey(name)) {
                    nameIndexMap.put(name, index++);
                }
            }

            for (String str : synonyms) {
                String[] tmpNameArr = str.substring(1, str.length() - 1).split(",");
                for (int i = 0; i < tmpNameArr.length; ++i) {
                    if (!nameIndexMap.containsKey(tmpNameArr[i])) {
                        nameIndexMap.put(tmpNameArr[i], index++);
                    }
                }
            }

            Map<Integer, String> indexNameMap = new HashMap<>();
            nameIndexMap.forEach((k, v) -> {
                indexNameMap.put(v, k);
            });

            UnionFind uf = new UnionFind(index);
            for (String str : synonyms) {
                String[] tmpNameArr = str.substring(1, str.length() - 1).split(",");
                for (int i = 1; i < tmpNameArr.length; ++i) {
                    uf.union(nameIndexMap.get(tmpNameArr[0]), nameIndexMap.get(tmpNameArr[i]), indexNameMap);
                }
            }



            int[] indexSumArr = new int[index];
            for (String nameFrequency : names) {
                int i = nameFrequency.indexOf('(');
                String name = nameFrequency.substring(0, i);
                int frequency = Integer.parseInt(nameFrequency.substring(i + 1, nameFrequency.length() - 1));
                indexSumArr[uf.findParent(nameIndexMap.get(name))] += frequency;
                System.out.println("aaaaa");
            }



            List<String> resList = new ArrayList<>();
            for (int i = 0; i < uf.parents.length; ++i) {
                if (i == uf.parents[i]) {
                    resList.add(indexNameMap.get(i) + "(" + indexSumArr[i] + ")");
                }
            }


            return resList.toArray(new String[0]);


        }
    }

    class UnionFind {
        public int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; ++i) {
                parents[i] = i;
            }
        }

        public void union(int x, int y, Map<Integer, String> indexStrMap) {
            int xParent = findParent(x);
            int yParent = findParent(y);

            if (xParent != yParent) {
                if (indexStrMap.get(xParent).compareTo(indexStrMap.get(yParent)) < 0) {
                    parents[yParent] = xParent;
                } else {
                    parents[xParent] = yParent;
                }
            }
        }

        public int findParent(int x) {
            if (x != parents[x]) {
                parents[x] = findParent(parents[x]);
            }
            return parents[x];
        }

        public boolean connected(int x, int y) {
            return findParent(x) == findParent(y);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
