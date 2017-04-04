package com.zkn.newlearn.tester.others;

import com.alibaba.fastjson.JSON;
import com.zkn.newlearn.domain.TreeStructureDomain;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkn on 2017/4/4.
 */
public class TreeStructureTest {

    private List<TreeStructureDomain> treeStructureDomains = new ArrayList<>(1);

    @Before
    public void wrapperTreeStructure() {
        TreeStructureDomain treeStructureDomain = new TreeStructureDomain();
        treeStructureDomain.setNum(12);
        treeStructureDomain.setTreeCode("0.1.");
        TreeStructureDomain treeStructureDomain02 = new TreeStructureDomain();
        treeStructureDomain02.setNum(15);
        treeStructureDomain02.setTreeCode("0.1.2.");
        TreeStructureDomain treeStructureDomain03 = new TreeStructureDomain();
        treeStructureDomain03.setNum(11);
        treeStructureDomain03.setTreeCode("0.1.3.");
        TreeStructureDomain treeStructureDomain04 = new TreeStructureDomain();
        treeStructureDomain04.setNum(13);
        treeStructureDomain04.setTreeCode("0.1.2.1.");
        TreeStructureDomain treeStructureDomain05 = new TreeStructureDomain();
        treeStructureDomain05.setNum(19);
        treeStructureDomain05.setTreeCode("0.1.2.2.");
        TreeStructureDomain treeStructureDomain06 = new TreeStructureDomain();
        treeStructureDomain06.setNum(18);
        treeStructureDomain06.setTreeCode("0.1.2.1.1.");
        TreeStructureDomain treeStructureDomain07 = new TreeStructureDomain();
        treeStructureDomain07.setNum(17);
        treeStructureDomain07.setTreeCode("0.1.2.1.2.");
        treeStructureDomain.setChildren(new ArrayList<TreeStructureDomain>() {
            {
                add(treeStructureDomain02);
                add(treeStructureDomain03);
            }
        });
        treeStructureDomain02.setChildren(new ArrayList<TreeStructureDomain>() {
            {
                add(treeStructureDomain04);
                add(treeStructureDomain05);
            }
        });
        treeStructureDomain04.setChildren(new ArrayList<TreeStructureDomain>() {
            {
                add(treeStructureDomain06);
                add(treeStructureDomain07);
            }
        });
        treeStructureDomains.add(treeStructureDomain);
        TreeStructureDomain treeStructureDomain1 = new TreeStructureDomain();
        treeStructureDomain1.setNum(12);
        treeStructureDomain1.setTreeCode("0.2.");
        TreeStructureDomain treeStructureDomain12 = new TreeStructureDomain();
        treeStructureDomain12.setNum(15);
        treeStructureDomain12.setTreeCode("0.2.2.");
        TreeStructureDomain treeStructureDomain13 = new TreeStructureDomain();
        treeStructureDomain13.setNum(20);
        treeStructureDomain13.setTreeCode("0.2.3.");
        TreeStructureDomain treeStructureDomain14 = new TreeStructureDomain();
        treeStructureDomain14.setNum(13);
        treeStructureDomain14.setTreeCode("0.2.2.1.");
        TreeStructureDomain treeStructureDomain15 = new TreeStructureDomain();
        treeStructureDomain15.setNum(19);
        treeStructureDomain15.setTreeCode("0.2.2.2.");
        TreeStructureDomain treeStructureDomain16 = new TreeStructureDomain();
        treeStructureDomain16.setNum(28);
        treeStructureDomain16.setTreeCode("0.2.2.1.1.");
        TreeStructureDomain treeStructureDomain17 = new TreeStructureDomain();
        treeStructureDomain17.setNum(17);
        treeStructureDomain17.setTreeCode("0.2.2.1.2.");
        treeStructureDomain1.setChildren(new ArrayList<TreeStructureDomain>() {
            {
                add(treeStructureDomain12);
                add(treeStructureDomain13);
            }
        });
        treeStructureDomain12.setChildren(new ArrayList<TreeStructureDomain>() {
            {
                add(treeStructureDomain14);
                //add(treeStructureDomain15);
            }
        });
//        treeStructureDomain14.setChildren(new ArrayList<TreeStructureDomain>() {
//            {
//                add(treeStructureDomain16);
//                add(treeStructureDomain17);
//            }
//        });
        treeStructureDomains.add(treeStructureDomain1);
    }

    @Test
    public void testStructure() {

        System.out.println(JSON.toJSONString(treeStructureDomains));
        List<Map<String, TreeStructureDomain>> leafNodeList = new ArrayList<>(treeStructureDomains.size());
        List<Map<String, TreeStructureDomain>> allNodeList = new ArrayList<>(treeStructureDomains.size());
        for (int i = 0; i < treeStructureDomains.size(); i++) {
            Map<String, TreeStructureDomain> leafNode = new HashMap<>();
            Map<String, TreeStructureDomain> allNode = new HashMap<>();
            deconstructionTree(treeStructureDomains.get(i), leafNode, allNode);
            leafNodeList.add(leafNode);
            allNodeList.add(allNode);
            System.out.println(JSON.toJSONString(leafNode));
            System.out.println(JSON.toJSONString(allNode));
        }
        for (int i = 0; i < treeStructureDomains.size(); i++) {
            //用来存放被计算过的节点
            Map<String, String> existsMap = new HashMap<>();
            for (Map.Entry<String, TreeStructureDomain> entry : leafNodeList.get(i).entrySet()) {
                int num = entry.getValue().getNum();
                String code = entry.getKey();
                code = code.substring(0, code.lastIndexOf("."));
                code = code.substring(0, code.lastIndexOf("."));
                //顶层节点
                while (!"0".equals(code)) {
                    //说明这个节点被计算过 一个节点只能被计算一次
                    if (existsMap.get(code) == null) {
                        if(allNodeList.get(i).get(code+".") != null){
                            num += allNodeList.get(i).get(code+".").getNum();
                            allNodeList.get(i).get(code+".").setNum(num);
                        }
                        existsMap.put(code,code);
                    }else {
                        if(allNodeList.get(i).get(code+".") != null){
                            allNodeList.get(i).get(code+".").setNum(allNodeList.get(i).get(code+".").getNum()+num);
                        }
                    }
                    code = code.substring(0, code.lastIndexOf("."));
                }
            }
        }
        System.out.println(JSON.toJSONString(treeStructureDomains));
    }

    private void deconstructionTree(TreeStructureDomain node, Map<String, TreeStructureDomain> leafNode, Map<String, TreeStructureDomain> allNode) {
        //组装成节点键值对
        allNode.put(node.getTreeCode(), node);
        //说明是叶子节点
        if (CollectionUtils.isEmpty(node.getChildren())) {
            leafNode.put(node.getTreeCode(), node);
            return;
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            deconstructionTree(node.getChildren().get(i), leafNode, allNode);
        }
    }

}
