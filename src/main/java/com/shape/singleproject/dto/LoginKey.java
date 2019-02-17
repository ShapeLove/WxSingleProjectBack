package com.shape.singleproject.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class LoginKey implements Serializable {

    private static final long serialVersionUID = 1550312572357L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:0
    */
    private String customKey;

    /**
    * 
    * isNullAble:0
    */
    private String openId;

    /**
    * 
    * isNullAble:0
    */
    private String sessionKey;

    public LoginKey() {
    }

    public LoginKey(Integer id, String customKey, String openId, String sessionKey) {
        this.id = id;
        this.customKey = customKey;
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setCustomKey(String customKey){this.customKey = customKey;}

    public String getCustomKey(){return this.customKey;}

    public void setOpenId(String openId){this.openId = openId;}

    public String getOpenId(){return this.openId;}

    public void setSessionKey(String sessionKey){this.sessionKey = sessionKey;}

    public String getSessionKey(){return this.sessionKey;}
    @Override
    public String toString() {
        return "LoginKey{" +
                "id='" + id + '\'' +
                "customKey='" + customKey + '\'' +
                "openId='" + openId + '\'' +
                "sessionKey='" + sessionKey + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private LoginKey set;

        private ConditionBuilder where;

        public UpdateBuilder set(LoginKey set){
            this.set = set;
            return this;
        }

        public LoginKey getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends LoginKey{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> customKeyList;

        public List<String> getCustomKeyList(){return this.customKeyList;}


        private List<String> fuzzyCustomKey;

        public List<String> getFuzzyCustomKey(){return this.fuzzyCustomKey;}

        private List<String> rightFuzzyCustomKey;

        public List<String> getRightFuzzyCustomKey(){return this.rightFuzzyCustomKey;}
        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
        private List<String> sessionKeyList;

        public List<String> getSessionKeyList(){return this.sessionKeyList;}


        private List<String> fuzzySessionKey;

        public List<String> getFuzzySessionKey(){return this.fuzzySessionKey;}

        private List<String> rightFuzzySessionKey;

        public List<String> getRightFuzzySessionKey(){return this.rightFuzzySessionKey;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyCustomKey (List<String> fuzzyCustomKey){
            this.fuzzyCustomKey = fuzzyCustomKey;
            return this;
        }

        public QueryBuilder fuzzyCustomKey (String ... fuzzyCustomKey){
            this.fuzzyCustomKey = solveNullList(fuzzyCustomKey);
            return this;
        }

        public QueryBuilder rightFuzzyCustomKey (List<String> rightFuzzyCustomKey){
            this.rightFuzzyCustomKey = rightFuzzyCustomKey;
            return this;
        }

        public QueryBuilder rightFuzzyCustomKey (String ... rightFuzzyCustomKey){
            this.rightFuzzyCustomKey = solveNullList(rightFuzzyCustomKey);
            return this;
        }

        public QueryBuilder customKey(String customKey){
            setCustomKey(customKey);
            return this;
        }

        public QueryBuilder customKeyList(String ... customKey){
            this.customKeyList = solveNullList(customKey);
            return this;
        }

        public QueryBuilder customKeyList(List<String> customKey){
            this.customKeyList = customKey;
            return this;
        }

        public QueryBuilder fetchCustomKey(){
            setFetchFields("fetchFields","customKey");
            return this;
        }

        public QueryBuilder excludeCustomKey(){
            setFetchFields("excludeFields","customKey");
            return this;
        }

        public QueryBuilder fuzzyOpenId (List<String> fuzzyOpenId){
            this.fuzzyOpenId = fuzzyOpenId;
            return this;
        }

        public QueryBuilder fuzzyOpenId (String ... fuzzyOpenId){
            this.fuzzyOpenId = solveNullList(fuzzyOpenId);
            return this;
        }

        public QueryBuilder rightFuzzyOpenId (List<String> rightFuzzyOpenId){
            this.rightFuzzyOpenId = rightFuzzyOpenId;
            return this;
        }

        public QueryBuilder rightFuzzyOpenId (String ... rightFuzzyOpenId){
            this.rightFuzzyOpenId = solveNullList(rightFuzzyOpenId);
            return this;
        }

        public QueryBuilder openId(String openId){
            setOpenId(openId);
            return this;
        }

        public QueryBuilder openIdList(String ... openId){
            this.openIdList = solveNullList(openId);
            return this;
        }

        public QueryBuilder openIdList(List<String> openId){
            this.openIdList = openId;
            return this;
        }

        public QueryBuilder fetchOpenId(){
            setFetchFields("fetchFields","openId");
            return this;
        }

        public QueryBuilder excludeOpenId(){
            setFetchFields("excludeFields","openId");
            return this;
        }

        public QueryBuilder fuzzySessionKey (List<String> fuzzySessionKey){
            this.fuzzySessionKey = fuzzySessionKey;
            return this;
        }

        public QueryBuilder fuzzySessionKey (String ... fuzzySessionKey){
            this.fuzzySessionKey = solveNullList(fuzzySessionKey);
            return this;
        }

        public QueryBuilder rightFuzzySessionKey (List<String> rightFuzzySessionKey){
            this.rightFuzzySessionKey = rightFuzzySessionKey;
            return this;
        }

        public QueryBuilder rightFuzzySessionKey (String ... rightFuzzySessionKey){
            this.rightFuzzySessionKey = solveNullList(rightFuzzySessionKey);
            return this;
        }

        public QueryBuilder sessionKey(String sessionKey){
            setSessionKey(sessionKey);
            return this;
        }

        public QueryBuilder sessionKeyList(String ... sessionKey){
            this.sessionKeyList = solveNullList(sessionKey);
            return this;
        }

        public QueryBuilder sessionKeyList(List<String> sessionKey){
            this.sessionKeyList = sessionKey;
            return this;
        }

        public QueryBuilder fetchSessionKey(){
            setFetchFields("fetchFields","sessionKey");
            return this;
        }

        public QueryBuilder excludeSessionKey(){
            setFetchFields("excludeFields","sessionKey");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public LoginKey build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> customKeyList;

        public List<String> getCustomKeyList(){return this.customKeyList;}


        private List<String> fuzzyCustomKey;

        public List<String> getFuzzyCustomKey(){return this.fuzzyCustomKey;}

        private List<String> rightFuzzyCustomKey;

        public List<String> getRightFuzzyCustomKey(){return this.rightFuzzyCustomKey;}
        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
        private List<String> sessionKeyList;

        public List<String> getSessionKeyList(){return this.sessionKeyList;}


        private List<String> fuzzySessionKey;

        public List<String> getFuzzySessionKey(){return this.fuzzySessionKey;}

        private List<String> rightFuzzySessionKey;

        public List<String> getRightFuzzySessionKey(){return this.rightFuzzySessionKey;}

        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyCustomKey (List<String> fuzzyCustomKey){
            this.fuzzyCustomKey = fuzzyCustomKey;
            return this;
        }

        public ConditionBuilder fuzzyCustomKey (String ... fuzzyCustomKey){
            this.fuzzyCustomKey = solveNullList(fuzzyCustomKey);
            return this;
        }

        public ConditionBuilder rightFuzzyCustomKey (List<String> rightFuzzyCustomKey){
            this.rightFuzzyCustomKey = rightFuzzyCustomKey;
            return this;
        }

        public ConditionBuilder rightFuzzyCustomKey (String ... rightFuzzyCustomKey){
            this.rightFuzzyCustomKey = solveNullList(rightFuzzyCustomKey);
            return this;
        }

        public ConditionBuilder customKeyList(String ... customKey){
            this.customKeyList = solveNullList(customKey);
            return this;
        }

        public ConditionBuilder customKeyList(List<String> customKey){
            this.customKeyList = customKey;
            return this;
        }

        public ConditionBuilder fuzzyOpenId (List<String> fuzzyOpenId){
            this.fuzzyOpenId = fuzzyOpenId;
            return this;
        }

        public ConditionBuilder fuzzyOpenId (String ... fuzzyOpenId){
            this.fuzzyOpenId = solveNullList(fuzzyOpenId);
            return this;
        }

        public ConditionBuilder rightFuzzyOpenId (List<String> rightFuzzyOpenId){
            this.rightFuzzyOpenId = rightFuzzyOpenId;
            return this;
        }

        public ConditionBuilder rightFuzzyOpenId (String ... rightFuzzyOpenId){
            this.rightFuzzyOpenId = solveNullList(rightFuzzyOpenId);
            return this;
        }

        public ConditionBuilder openIdList(String ... openId){
            this.openIdList = solveNullList(openId);
            return this;
        }

        public ConditionBuilder openIdList(List<String> openId){
            this.openIdList = openId;
            return this;
        }

        public ConditionBuilder fuzzySessionKey (List<String> fuzzySessionKey){
            this.fuzzySessionKey = fuzzySessionKey;
            return this;
        }

        public ConditionBuilder fuzzySessionKey (String ... fuzzySessionKey){
            this.fuzzySessionKey = solveNullList(fuzzySessionKey);
            return this;
        }

        public ConditionBuilder rightFuzzySessionKey (List<String> rightFuzzySessionKey){
            this.rightFuzzySessionKey = rightFuzzySessionKey;
            return this;
        }

        public ConditionBuilder rightFuzzySessionKey (String ... rightFuzzySessionKey){
            this.rightFuzzySessionKey = solveNullList(rightFuzzySessionKey);
            return this;
        }

        public ConditionBuilder sessionKeyList(String ... sessionKey){
            this.sessionKeyList = solveNullList(sessionKey);
            return this;
        }

        public ConditionBuilder sessionKeyList(List<String> sessionKey){
            this.sessionKeyList = sessionKey;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private LoginKey obj;

        public Builder(){
            this.obj = new LoginKey();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder customKey(String customKey){
            this.obj.setCustomKey(customKey);
            return this;
        }
        public Builder openId(String openId){
            this.obj.setOpenId(openId);
            return this;
        }
        public Builder sessionKey(String sessionKey){
            this.obj.setSessionKey(sessionKey);
            return this;
        }
        public LoginKey build(){return obj;}
    }

}
