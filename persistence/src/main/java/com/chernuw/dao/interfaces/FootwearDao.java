package com.chernuw.dao.interfaces;


    import com.chernuw.model.Footwear;
    import org.hibernate.criterion.Criterion;
    import org.springframework.ui.Model;

    import java.io.UnsupportedEncodingException;
    import java.util.List;

    public interface FootwearDao {

        Footwear getById(int id);
        List<Footwear> getAll(int numberOfPage, int amountOnPage);
        List<Footwear> getAll();
        List<Footwear> getByCriterion(Criterion criterion);
        List<Footwear> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage);
//        void updateFootwear(Footwear footwear);
//        void updateFootwear(int id, Model model) throws UnsupportedEncodingException;
        void deleteFootwear(Footwear footwear);
        int saveFootwear(Footwear footwear);
    }
