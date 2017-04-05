package com.zkn.newlearn.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zkn on 2017/4/4.
 */
public class TreeStructureDomain implements Serializable{

    private static final long serialVersionUID = 3522498124920821413L;
    /**
     * 总和
     */
    private Integer num;
    /**
     * 编码
     */
    private String treeCode;
    /**
     *  上下级关系
     */
    private List<TreeStructureDomain> children;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public List<TreeStructureDomain> getChildren() {
        return children;
    }

    public void setChildren(List<TreeStructureDomain> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeStructureDomain{" +
                "num=" + num +
                ", treeCode='" + treeCode + '\'' +
                ", children=" + children +
                '}';
    }
}
