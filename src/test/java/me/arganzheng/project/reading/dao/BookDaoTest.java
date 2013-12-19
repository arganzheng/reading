package me.arganzheng.project.reading.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.model.Book;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

/**
 * TODO 类实现描述
 * 
 * @author arganzheng
 * @date 2013-12-18
 */
public class BookDaoTest extends BaseSpringTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testSelectBookByISBN() {
        String isbn = "isbn10";
        Book book = bookDao.selectBookByISBN(isbn);
        Assert.notNull(book);

    }

    @Test
    @Rollback(false)
    public void testInsert() {
        Book book = new Book();

        book.setTitle("小王子");
        Date pubDate = new Date();
        DateUtils.setYears(pubDate, 2000);
        DateUtils.setMonths(pubDate, 9);
        DateUtils.setDays(pubDate, 1);
        book.setPubdate(pubDate);
        book.setDetailLink("http://book.douban.com/subject/1003078/");
        book.setImage("http://img3.douban.com/mpic/s26698262.jpg");
        book.setIsbn10("7505715666");
        book.setIsbn13("9787505715660");

        List<String> authors = new ArrayList<String>();
        authors.add("（法）圣埃克苏佩里");
        book.setAuthors(authors);

        book.setPageCount(111);
        book.setSummary("小王子驾到！大家好，我是小王子，生活在B612星球，别看我是王子出生，我要做的事也不少，有时给花浇水，有时我还得耐心地把火山口通一通。实在闷得发慌的时候，为了找些事做，学点东西，我也访问一些其他的星球，像325号、326号、327号之类的。当然，我经历的事情也不少，有开心的，也有不开心的。这些事我通常会向地球上一个叫圣埃克苏佩里的人倾诉。对了，你可不要小瞧他，他是拿但业的儿子，琐罗亚斯德的孙子。他还被人们认为尼采式的第二代法国作家。他一生有两大爱好：飞行和写作。我之所以能够这样受欢迎也是他的功劳。因为他把我在其他星球的所见所闻编成了一本小书，也就是你们即将看到的这一本。它不但被誉为有史以来阅读仅次于《圣经》的书，全球发行的语言更是超过100种。可惜的是，在这本书出版后没多久，他在一次架机执行任务时一去不复返了，没有人知道他去了哪里。今天我第一次来到中国，还希望大家同样能够喜欢我。在这本书里他收藏了很多我在其他星球的精美彩图，而且，值得一提的是，中国著名的评论家周国平先生也特意为我作序。可以说，这本书不仅小朋友们爱不释手，就连大人们也会看得如痴如醉。糟糕，我还忘了告诉你，你只有在卓越网（www.joyo.com）才能找到我。有缘的话，我们很快就能相见了。\n尼采、纪德、圣埃克苏佩里是同一家庭的成员，由无可否认的联系连在一起。圣埃克苏佩里热爱尼采。纪德热爱圣埃克苏佩里。\n1945年2月1日《费加罗报》上，他谈到这位飞行员：\"他无论在何处着陆，都是为了带去欢乐。\"\n但是圣埃克苏佩里将公正置于友谊之上。他在《札记》中写道：\"纪德评价，却不曾体验。\"确切的见解。这是行动者面对思想者所感到的骄傲。尼采和纪德孕育了一种道德，并用美妙的文学冲动表现出来。只有圣埃克苏佩里一人在危险和充实中体验了这种道德。他是翱翔于九天的琐罗亚斯德，是乘风飞去的拿但业。他的书房便是机舱。他的格言：事事体验。他的作品：生活。圣埃克苏佩里对尼采的力量和纪德的热诚做作了合理的总结：他的冒险为职业，把写作当嗜好，他在飞行员的位置上实现着克尔桤郭尔的愿望：\"做一个思想家和做一个人，二者尽量不要区别开来，这样才是明智的。\"--（法）玛雅·戴斯特莱姆");

        List<String> tags = new ArrayList<String>();
        tags.add("小王子");
        tags.add("童话");
        book.setTags(tags);

        List<String> owners = new ArrayList<String>();
        owners.add("arganzheng");
        owners.add("magi");
        book.setOwners(owners);

        int id = bookDao.insert(book);
        Assert.isTrue(id > 0);

    }
}