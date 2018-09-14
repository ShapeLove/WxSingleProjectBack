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
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1536901309704L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    private String optionId;

    /**
    * 
    * isNullAble:1
    */
    private String name;

    /**
    * 
    * isNullAble:0,defaultVal:1
    */
    private Integer yn;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setOptionId(String optionId){this.optionId = optionId;}

    public String getOptionId(){return this.optionId;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setYn(Integer yn){this.yn = yn;}

    public Integer getYn(){return this.yn;}
    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                "optionId='" + optionId + '\'' +
                "name='" + name + '\'' +
                "yn='" + yn + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private UserInfo set;

        private ConditionBuilder where;

        public UpdateBuilder set(UserInfo set){
            this.set = set;
            return this;
        }

        public UserInfo getSet(){
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

    public static class QueryBuilder extends UserInfo{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> optionIdList;

        public List<String> getOptionIdList(){return this.optionIdList;}


        private List<String> fuzzyOptionId;

        public List<String> getFuzzyOptionId(){return this.fuzzyOptionId;}

        private List<String> rightFuzzyOptionId;

        public List<String> getRightFuzzyOptionId(){return this.rightFuzzyOptionId;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> ynList;

        public List<Integer> getYnList(){return this.ynList;}

        private Integer ynSt;

        private Integer ynEd;

        public Integer getYnSt(){return this.ynSt;}

        public Integer getYnEd(){return this.ynEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Long id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Long> id){
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

        public QueryBuilder fuzzyOptionId (List<String> fuzzyOptionId){
            this.fuzzyOptionId = fuzzyOptionId;
            return this;
        }

        public QueryBuilder fuzzyOptionId (String ... fuzzyOptionId){
            this.fuzzyOptionId = solveNullList(fuzzyOptionId);
            return this;
        }

        public QueryBuilder rightFuzzyOptionId (List<String> rightFuzzyOptionId){
            this.rightFuzzyOptionId = rightFuzzyOptionId;
            return this;
        }

        public QueryBuilder rightFuzzyOptionId (String ... rightFuzzyOptionId){
            this.rightFuzzyOptionId = solveNullList(rightFuzzyOptionId);
            return this;
        }

        public QueryBuilder optionId(String optionId){
            setOptionId(optionId);
            return this;
        }

        public QueryBuilder optionIdList(String ... optionId){
            this.optionIdList = solveNullList(optionId);
            return this;
        }

        public QueryBuilder optionIdList(List<String> optionId){
            this.optionIdList = optionId;
            return this;
        }

        public QueryBuilder fetchOptionId(){
            setFetchFields("fetchFields","optionId");
            return this;
        }

        public QueryBuilder excludeOptionId(){
            setFetchFields("excludeFields","optionId");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder ynBetWeen(Integer ynSt,Integer ynEd){
            this.ynSt = ynSt;
            this.ynEd = ynEd;
            return this;
        }

        public QueryBuilder ynGreaterEqThan(Integer ynSt){
            this.ynSt = ynSt;
            return this;
        }
        public QueryBuilder ynLessEqThan(Integer ynEd){
            this.ynEd = ynEd;
            return this;
        }


        public QueryBuilder yn(Integer yn){
            setYn(yn);
            return this;
        }

        public QueryBuilder ynList(Integer ... yn){
            this.ynList = solveNullList(yn);
            return this;
        }

        public QueryBuilder ynList(List<Integer> yn){
            this.ynList = yn;
            return this;
        }

        public QueryBuilder fetchYn(){
            setFetchFields("fetchFields","yn");
            return this;
        }

        public QueryBuilder excludeYn(){
            setFetchFields("excludeFields","yn");
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

        public UserInfo build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> optionIdList;

        public List<String> getOptionIdList(){return this.optionIdList;}


        private List<String> fuzzyOptionId;

        public List<String> getFuzzyOptionId(){return this.fuzzyOptionId;}

        private List<String> rightFuzzyOptionId;

        public List<String> getRightFuzzyOptionId(){return this.rightFuzzyOptionId;}
        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> ynList;

        public List<Integer> getYnList(){return this.ynList;}

        private Integer ynSt;

        private Integer ynEd;

        public Integer getYnSt(){return this.ynSt;}

        public Integer getYnEd(){return this.ynEd;}


        public ConditionBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyOptionId (List<String> fuzzyOptionId){
            this.fuzzyOptionId = fuzzyOptionId;
            return this;
        }

        public ConditionBuilder fuzzyOptionId (String ... fuzzyOptionId){
            this.fuzzyOptionId = solveNullList(fuzzyOptionId);
            return this;
        }

        public ConditionBuilder rightFuzzyOptionId (List<String> rightFuzzyOptionId){
            this.rightFuzzyOptionId = rightFuzzyOptionId;
            return this;
        }

        public ConditionBuilder rightFuzzyOptionId (String ... rightFuzzyOptionId){
            this.rightFuzzyOptionId = solveNullList(rightFuzzyOptionId);
            return this;
        }

        public ConditionBuilder optionIdList(String ... optionId){
            this.optionIdList = solveNullList(optionId);
            return this;
        }

        public ConditionBuilder optionIdList(List<String> optionId){
            this.optionIdList = optionId;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder ynBetWeen(Integer ynSt,Integer ynEd){
            this.ynSt = ynSt;
            this.ynEd = ynEd;
            return this;
        }

        public ConditionBuilder ynGreaterEqThan(Integer ynSt){
            this.ynSt = ynSt;
            return this;
        }
        public ConditionBuilder ynLessEqThan(Integer ynEd){
            this.ynEd = ynEd;
            return this;
        }


        public ConditionBuilder ynList(Integer ... yn){
            this.ynList = solveNullList(yn);
            return this;
        }

        public ConditionBuilder ynList(List<Integer> yn){
            this.ynList = yn;
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

        private UserInfo obj;

        public Builder(){
            this.obj = new UserInfo();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder optionId(String optionId){
            this.obj.setOptionId(optionId);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder yn(Integer yn){
            this.obj.setYn(yn);
            return this;
        }
        public UserInfo build(){return obj;}
    }

}
