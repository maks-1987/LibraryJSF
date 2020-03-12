package controller;

import enums.SearchType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SearchController implements Serializable {
    private SearchType searchType;
    private static Map<String, SearchType> searchTypeMap = new HashMap<>();

    public SearchController() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("nls.message",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        searchTypeMap.put(resourceBundle.getString("author_name"), SearchType.AUTHOR);
        searchTypeMap.put(resourceBundle.getString("book_name"), SearchType.TITLE);
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public Map<String, SearchType> getSearchList() {
        return searchTypeMap;
    }
}
