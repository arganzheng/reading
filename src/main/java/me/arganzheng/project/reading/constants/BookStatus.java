package me.arganzheng.project.reading.constants;

/**
 * 书籍的状态
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public enum BookStatus {
    OnShelf, // 上架，归还
    OffShelf, // 下架
    Lent, // 借出
    Return;// 归还，主要用于借阅关系表中。
}
