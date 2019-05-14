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
public class Tags implements Serializable {

    private static final long serialVersionUID = 1557806351455L;


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
    private String tagName;

    /**
    * 
    * isNullAble:0,defaultVal:0000-00-00 00:00:00
    */
    private java.time.LocalDateTime create;

    /**
    * 
    * isNullAble:0
    */
    private Integer tagType;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setTagName(String tagName){this.tagName = tagName;}

    public String getTagName(){return this.tagName;}

    public void setCreate(java.time.LocalDateTime create){this.create = create;}

    public java.time.LocalDateTime getCreate(){return this.create;}

    public void setTagType(Integer tagType){this.tagType = tagType;}

    public Integer getTagType(){return this.tagType;}
    @Override
    public String toString() {
        return "Tags{" +
                "id='" + id + '\'' +
                "tagName='" + tagName + '\'' +
                "create='" + create + '\'' +
                "tagType='" + tagType + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Tags set;

        private ConditionBuilder where;

        public UpdateBuilder set(Tags set){
            this.set = set;
            return this;
        }

        public Tags getSet(){
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

    public static class QueryBuilder extends Tags{
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

        private List<String> tagNameList;

        public List<String> getTagNameList(){return this.tagNameList;}


        private List<String> fuzzyTagName;

        public List<String> getFuzzyTagName(){return this.fuzzyTagName;}

        private List<String> rightFuzzyTagName;

        public List<String> getRightFuzzyTagName(){return this.rightFuzzyTagName;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<Integer> tagTypeList;

        public List<Integer> getTagTypeList(){return this.tagTypeList;}

        private Integer tagTypeSt;

        private Integer tagTypeEd;

        public Integer getTagTypeSt(){return this.tagTypeSt;}

        public Integer getTagTypeEd(){return this.tagTypeEd;}

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

        public QueryBuilder fuzzyTagName (List<String> fuzzyTagName){
            this.fuzzyTagName = fuzzyTagName;
            return this;
        }

        public QueryBuilder fuzzyTagName (String ... fuzzyTagName){
            this.fuzzyTagName = solveNullList(fuzzyTagName);
            return this;
        }

        public QueryBuilder rightFuzzyTagName (List<String> rightFuzzyTagName){
            this.rightFuzzyTagName = rightFuzzyTagName;
            return this;
        }

        public QueryBuilder rightFuzzyTagName (String ... rightFuzzyTagName){
            this.rightFuzzyTagName = solveNullList(rightFuzzyTagName);
            return this;
        }

        public QueryBuilder tagName(String tagName){
            setTagName(tagName);
            return this;
        }

        public QueryBuilder tagNameList(String ... tagName){
            this.tagNameList = solveNullList(tagName);
            return this;
        }

        public QueryBuilder tagNameList(List<String> tagName){
            this.tagNameList = tagName;
            return this;
        }

        public QueryBuilder fetchTagName(){
            setFetchFields("fetchFields","tagName");
            return this;
        }

        public QueryBuilder excludeTagName(){
            setFetchFields("excludeFields","tagName");
            return this;
        }

        public QueryBuilder createBetWeen(java.time.LocalDateTime createSt,java.time.LocalDateTime createEd){
            this.createSt = createSt;
            this.createEd = createEd;
            return this;
        }

        public QueryBuilder createGreaterEqThan(java.time.LocalDateTime createSt){
            this.createSt = createSt;
            return this;
        }
        public QueryBuilder createLessEqThan(java.time.LocalDateTime createEd){
            this.createEd = createEd;
            return this;
        }


        public QueryBuilder create(java.time.LocalDateTime create){
            setCreate(create);
            return this;
        }

        public QueryBuilder createList(java.time.LocalDateTime ... create){
            this.createList = solveNullList(create);
            return this;
        }

        public QueryBuilder createList(List<java.time.LocalDateTime> create){
            this.createList = create;
            return this;
        }

        public QueryBuilder fetchCreate(){
            setFetchFields("fetchFields","create");
            return this;
        }

        public QueryBuilder excludeCreate(){
            setFetchFields("excludeFields","create");
            return this;
        }

        public QueryBuilder tagTypeBetWeen(Integer tagTypeSt,Integer tagTypeEd){
            this.tagTypeSt = tagTypeSt;
            this.tagTypeEd = tagTypeEd;
            return this;
        }

        public QueryBuilder tagTypeGreaterEqThan(Integer tagTypeSt){
            this.tagTypeSt = tagTypeSt;
            return this;
        }
        public QueryBuilder tagTypeLessEqThan(Integer tagTypeEd){
            this.tagTypeEd = tagTypeEd;
            return this;
        }


        public QueryBuilder tagType(Integer tagType){
            setTagType(tagType);
            return this;
        }

        public QueryBuilder tagTypeList(Integer ... tagType){
            this.tagTypeList = solveNullList(tagType);
            return this;
        }

        public QueryBuilder tagTypeList(List<Integer> tagType){
            this.tagTypeList = tagType;
            return this;
        }

        public QueryBuilder fetchTagType(){
            setFetchFields("fetchFields","tagType");
            return this;
        }

        public QueryBuilder excludeTagType(){
            setFetchFields("excludeFields","tagType");
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

        public Tags build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> tagNameList;

        public List<String> getTagNameList(){return this.tagNameList;}


        private List<String> fuzzyTagName;

        public List<String> getFuzzyTagName(){return this.fuzzyTagName;}

        private List<String> rightFuzzyTagName;

        public List<String> getRightFuzzyTagName(){return this.rightFuzzyTagName;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<Integer> tagTypeList;

        public List<Integer> getTagTypeList(){return this.tagTypeList;}

        private Integer tagTypeSt;

        private Integer tagTypeEd;

        public Integer getTagTypeSt(){return this.tagTypeSt;}

        public Integer getTagTypeEd(){return this.tagTypeEd;}


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

        public ConditionBuilder fuzzyTagName (List<String> fuzzyTagName){
            this.fuzzyTagName = fuzzyTagName;
            return this;
        }

        public ConditionBuilder fuzzyTagName (String ... fuzzyTagName){
            this.fuzzyTagName = solveNullList(fuzzyTagName);
            return this;
        }

        public ConditionBuilder rightFuzzyTagName (List<String> rightFuzzyTagName){
            this.rightFuzzyTagName = rightFuzzyTagName;
            return this;
        }

        public ConditionBuilder rightFuzzyTagName (String ... rightFuzzyTagName){
            this.rightFuzzyTagName = solveNullList(rightFuzzyTagName);
            return this;
        }

        public ConditionBuilder tagNameList(String ... tagName){
            this.tagNameList = solveNullList(tagName);
            return this;
        }

        public ConditionBuilder tagNameList(List<String> tagName){
            this.tagNameList = tagName;
            return this;
        }

        public ConditionBuilder createBetWeen(java.time.LocalDateTime createSt,java.time.LocalDateTime createEd){
            this.createSt = createSt;
            this.createEd = createEd;
            return this;
        }

        public ConditionBuilder createGreaterEqThan(java.time.LocalDateTime createSt){
            this.createSt = createSt;
            return this;
        }
        public ConditionBuilder createLessEqThan(java.time.LocalDateTime createEd){
            this.createEd = createEd;
            return this;
        }


        public ConditionBuilder createList(java.time.LocalDateTime ... create){
            this.createList = solveNullList(create);
            return this;
        }

        public ConditionBuilder createList(List<java.time.LocalDateTime> create){
            this.createList = create;
            return this;
        }

        public ConditionBuilder tagTypeBetWeen(Integer tagTypeSt,Integer tagTypeEd){
            this.tagTypeSt = tagTypeSt;
            this.tagTypeEd = tagTypeEd;
            return this;
        }

        public ConditionBuilder tagTypeGreaterEqThan(Integer tagTypeSt){
            this.tagTypeSt = tagTypeSt;
            return this;
        }
        public ConditionBuilder tagTypeLessEqThan(Integer tagTypeEd){
            this.tagTypeEd = tagTypeEd;
            return this;
        }


        public ConditionBuilder tagTypeList(Integer ... tagType){
            this.tagTypeList = solveNullList(tagType);
            return this;
        }

        public ConditionBuilder tagTypeList(List<Integer> tagType){
            this.tagTypeList = tagType;
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

        private Tags obj;

        public Builder(){
            this.obj = new Tags();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder tagName(String tagName){
            this.obj.setTagName(tagName);
            return this;
        }
        public Builder create(java.time.LocalDateTime create){
            this.obj.setCreate(create);
            return this;
        }
        public Builder tagType(Integer tagType){
            this.obj.setTagType(tagType);
            return this;
        }
        public Tags build(){return obj;}
    }

}
