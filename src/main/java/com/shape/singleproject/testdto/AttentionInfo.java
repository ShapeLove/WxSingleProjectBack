package com.shape.singleproject.testdto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class AttentionInfo implements Serializable {

    private static final long serialVersionUID = 1560160258566L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 关注者id
    * isNullAble:0
    */
    private String attentionOpenid;

    /**
    * 关注者状态(0:关注 默认，1：不关注）
    * isNullAble:0,defaultVal:0
    */
    private Integer attentionStatus;

    /**
    * 被关注者id
    * isNullAble:0
    */
    private String toAttentionOpenid;

    /**
    * 被关注者状态(1:不关注 默认 0：关注）
    * isNullAble:0,defaultVal:1
    */
    private Integer toAttentionStatus;

    /**
    * 冗余字段
    * isNullAble:1
    */
    private String ext;

    /**
    * 创建时间
    * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime create;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setAttentionOpenid(String attentionOpenid){this.attentionOpenid = attentionOpenid;}

    public String getAttentionOpenid(){return this.attentionOpenid;}

    public void setAttentionStatus(Integer attentionStatus){this.attentionStatus = attentionStatus;}

    public Integer getAttentionStatus(){return this.attentionStatus;}

    public void setToAttentionOpenid(String toAttentionOpenid){this.toAttentionOpenid = toAttentionOpenid;}

    public String getToAttentionOpenid(){return this.toAttentionOpenid;}

    public void setToAttentionStatus(Integer toAttentionStatus){this.toAttentionStatus = toAttentionStatus;}

    public Integer getToAttentionStatus(){return this.toAttentionStatus;}

    public void setExt(String ext){this.ext = ext;}

    public String getExt(){return this.ext;}

    public void setCreate(java.time.LocalDateTime create){this.create = create;}

    public java.time.LocalDateTime getCreate(){return this.create;}
    @Override
    public String toString() {
        return "AttentionInfo{" +
                "id='" + id + '\'' +
                "attentionOpenid='" + attentionOpenid + '\'' +
                "attentionStatus='" + attentionStatus + '\'' +
                "toAttentionOpenid='" + toAttentionOpenid + '\'' +
                "toAttentionStatus='" + toAttentionStatus + '\'' +
                "ext='" + ext + '\'' +
                "create='" + create + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private AttentionInfo set;

        private ConditionBuilder where;

        public UpdateBuilder set(AttentionInfo set){
            this.set = set;
            return this;
        }

        public AttentionInfo getSet(){
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

    public static class QueryBuilder extends AttentionInfo{
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

        private List<String> attentionOpenidList;

        public List<String> getAttentionOpenidList(){return this.attentionOpenidList;}


        private List<String> fuzzyAttentionOpenid;

        public List<String> getFuzzyAttentionOpenid(){return this.fuzzyAttentionOpenid;}

        private List<String> rightFuzzyAttentionOpenid;

        public List<String> getRightFuzzyAttentionOpenid(){return this.rightFuzzyAttentionOpenid;}
        private List<Integer> attentionStatusList;

        public List<Integer> getAttentionStatusList(){return this.attentionStatusList;}

        private Integer attentionStatusSt;

        private Integer attentionStatusEd;

        public Integer getAttentionStatusSt(){return this.attentionStatusSt;}

        public Integer getAttentionStatusEd(){return this.attentionStatusEd;}

        private List<String> toAttentionOpenidList;

        public List<String> getToAttentionOpenidList(){return this.toAttentionOpenidList;}


        private List<String> fuzzyToAttentionOpenid;

        public List<String> getFuzzyToAttentionOpenid(){return this.fuzzyToAttentionOpenid;}

        private List<String> rightFuzzyToAttentionOpenid;

        public List<String> getRightFuzzyToAttentionOpenid(){return this.rightFuzzyToAttentionOpenid;}
        private List<Integer> toAttentionStatusList;

        public List<Integer> getToAttentionStatusList(){return this.toAttentionStatusList;}

        private Integer toAttentionStatusSt;

        private Integer toAttentionStatusEd;

        public Integer getToAttentionStatusSt(){return this.toAttentionStatusSt;}

        public Integer getToAttentionStatusEd(){return this.toAttentionStatusEd;}

        private List<String> extList;

        public List<String> getExtList(){return this.extList;}


        private List<String> fuzzyExt;

        public List<String> getFuzzyExt(){return this.fuzzyExt;}

        private List<String> rightFuzzyExt;

        public List<String> getRightFuzzyExt(){return this.rightFuzzyExt;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

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

        public QueryBuilder fuzzyAttentionOpenid (List<String> fuzzyAttentionOpenid){
            this.fuzzyAttentionOpenid = fuzzyAttentionOpenid;
            return this;
        }

        public QueryBuilder fuzzyAttentionOpenid (String ... fuzzyAttentionOpenid){
            this.fuzzyAttentionOpenid = solveNullList(fuzzyAttentionOpenid);
            return this;
        }

        public QueryBuilder rightFuzzyAttentionOpenid (List<String> rightFuzzyAttentionOpenid){
            this.rightFuzzyAttentionOpenid = rightFuzzyAttentionOpenid;
            return this;
        }

        public QueryBuilder rightFuzzyAttentionOpenid (String ... rightFuzzyAttentionOpenid){
            this.rightFuzzyAttentionOpenid = solveNullList(rightFuzzyAttentionOpenid);
            return this;
        }

        public QueryBuilder attentionOpenid(String attentionOpenid){
            setAttentionOpenid(attentionOpenid);
            return this;
        }

        public QueryBuilder attentionOpenidList(String ... attentionOpenid){
            this.attentionOpenidList = solveNullList(attentionOpenid);
            return this;
        }

        public QueryBuilder attentionOpenidList(List<String> attentionOpenid){
            this.attentionOpenidList = attentionOpenid;
            return this;
        }

        public QueryBuilder fetchAttentionOpenid(){
            setFetchFields("fetchFields","attentionOpenid");
            return this;
        }

        public QueryBuilder excludeAttentionOpenid(){
            setFetchFields("excludeFields","attentionOpenid");
            return this;
        }

        public QueryBuilder attentionStatusBetWeen(Integer attentionStatusSt,Integer attentionStatusEd){
            this.attentionStatusSt = attentionStatusSt;
            this.attentionStatusEd = attentionStatusEd;
            return this;
        }

        public QueryBuilder attentionStatusGreaterEqThan(Integer attentionStatusSt){
            this.attentionStatusSt = attentionStatusSt;
            return this;
        }
        public QueryBuilder attentionStatusLessEqThan(Integer attentionStatusEd){
            this.attentionStatusEd = attentionStatusEd;
            return this;
        }


        public QueryBuilder attentionStatus(Integer attentionStatus){
            setAttentionStatus(attentionStatus);
            return this;
        }

        public QueryBuilder attentionStatusList(Integer ... attentionStatus){
            this.attentionStatusList = solveNullList(attentionStatus);
            return this;
        }

        public QueryBuilder attentionStatusList(List<Integer> attentionStatus){
            this.attentionStatusList = attentionStatus;
            return this;
        }

        public QueryBuilder fetchAttentionStatus(){
            setFetchFields("fetchFields","attentionStatus");
            return this;
        }

        public QueryBuilder excludeAttentionStatus(){
            setFetchFields("excludeFields","attentionStatus");
            return this;
        }

        public QueryBuilder fuzzyToAttentionOpenid (List<String> fuzzyToAttentionOpenid){
            this.fuzzyToAttentionOpenid = fuzzyToAttentionOpenid;
            return this;
        }

        public QueryBuilder fuzzyToAttentionOpenid (String ... fuzzyToAttentionOpenid){
            this.fuzzyToAttentionOpenid = solveNullList(fuzzyToAttentionOpenid);
            return this;
        }

        public QueryBuilder rightFuzzyToAttentionOpenid (List<String> rightFuzzyToAttentionOpenid){
            this.rightFuzzyToAttentionOpenid = rightFuzzyToAttentionOpenid;
            return this;
        }

        public QueryBuilder rightFuzzyToAttentionOpenid (String ... rightFuzzyToAttentionOpenid){
            this.rightFuzzyToAttentionOpenid = solveNullList(rightFuzzyToAttentionOpenid);
            return this;
        }

        public QueryBuilder toAttentionOpenid(String toAttentionOpenid){
            setToAttentionOpenid(toAttentionOpenid);
            return this;
        }

        public QueryBuilder toAttentionOpenidList(String ... toAttentionOpenid){
            this.toAttentionOpenidList = solveNullList(toAttentionOpenid);
            return this;
        }

        public QueryBuilder toAttentionOpenidList(List<String> toAttentionOpenid){
            this.toAttentionOpenidList = toAttentionOpenid;
            return this;
        }

        public QueryBuilder fetchToAttentionOpenid(){
            setFetchFields("fetchFields","toAttentionOpenid");
            return this;
        }

        public QueryBuilder excludeToAttentionOpenid(){
            setFetchFields("excludeFields","toAttentionOpenid");
            return this;
        }

        public QueryBuilder toAttentionStatusBetWeen(Integer toAttentionStatusSt,Integer toAttentionStatusEd){
            this.toAttentionStatusSt = toAttentionStatusSt;
            this.toAttentionStatusEd = toAttentionStatusEd;
            return this;
        }

        public QueryBuilder toAttentionStatusGreaterEqThan(Integer toAttentionStatusSt){
            this.toAttentionStatusSt = toAttentionStatusSt;
            return this;
        }
        public QueryBuilder toAttentionStatusLessEqThan(Integer toAttentionStatusEd){
            this.toAttentionStatusEd = toAttentionStatusEd;
            return this;
        }


        public QueryBuilder toAttentionStatus(Integer toAttentionStatus){
            setToAttentionStatus(toAttentionStatus);
            return this;
        }

        public QueryBuilder toAttentionStatusList(Integer ... toAttentionStatus){
            this.toAttentionStatusList = solveNullList(toAttentionStatus);
            return this;
        }

        public QueryBuilder toAttentionStatusList(List<Integer> toAttentionStatus){
            this.toAttentionStatusList = toAttentionStatus;
            return this;
        }

        public QueryBuilder fetchToAttentionStatus(){
            setFetchFields("fetchFields","toAttentionStatus");
            return this;
        }

        public QueryBuilder excludeToAttentionStatus(){
            setFetchFields("excludeFields","toAttentionStatus");
            return this;
        }

        public QueryBuilder fuzzyExt (List<String> fuzzyExt){
            this.fuzzyExt = fuzzyExt;
            return this;
        }

        public QueryBuilder fuzzyExt (String ... fuzzyExt){
            this.fuzzyExt = solveNullList(fuzzyExt);
            return this;
        }

        public QueryBuilder rightFuzzyExt (List<String> rightFuzzyExt){
            this.rightFuzzyExt = rightFuzzyExt;
            return this;
        }

        public QueryBuilder rightFuzzyExt (String ... rightFuzzyExt){
            this.rightFuzzyExt = solveNullList(rightFuzzyExt);
            return this;
        }

        public QueryBuilder ext(String ext){
            setExt(ext);
            return this;
        }

        public QueryBuilder extList(String ... ext){
            this.extList = solveNullList(ext);
            return this;
        }

        public QueryBuilder extList(List<String> ext){
            this.extList = ext;
            return this;
        }

        public QueryBuilder fetchExt(){
            setFetchFields("fetchFields","ext");
            return this;
        }

        public QueryBuilder excludeExt(){
            setFetchFields("excludeFields","ext");
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

        public AttentionInfo build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> attentionOpenidList;

        public List<String> getAttentionOpenidList(){return this.attentionOpenidList;}


        private List<String> fuzzyAttentionOpenid;

        public List<String> getFuzzyAttentionOpenid(){return this.fuzzyAttentionOpenid;}

        private List<String> rightFuzzyAttentionOpenid;

        public List<String> getRightFuzzyAttentionOpenid(){return this.rightFuzzyAttentionOpenid;}
        private List<Integer> attentionStatusList;

        public List<Integer> getAttentionStatusList(){return this.attentionStatusList;}

        private Integer attentionStatusSt;

        private Integer attentionStatusEd;

        public Integer getAttentionStatusSt(){return this.attentionStatusSt;}

        public Integer getAttentionStatusEd(){return this.attentionStatusEd;}

        private List<String> toAttentionOpenidList;

        public List<String> getToAttentionOpenidList(){return this.toAttentionOpenidList;}


        private List<String> fuzzyToAttentionOpenid;

        public List<String> getFuzzyToAttentionOpenid(){return this.fuzzyToAttentionOpenid;}

        private List<String> rightFuzzyToAttentionOpenid;

        public List<String> getRightFuzzyToAttentionOpenid(){return this.rightFuzzyToAttentionOpenid;}
        private List<Integer> toAttentionStatusList;

        public List<Integer> getToAttentionStatusList(){return this.toAttentionStatusList;}

        private Integer toAttentionStatusSt;

        private Integer toAttentionStatusEd;

        public Integer getToAttentionStatusSt(){return this.toAttentionStatusSt;}

        public Integer getToAttentionStatusEd(){return this.toAttentionStatusEd;}

        private List<String> extList;

        public List<String> getExtList(){return this.extList;}


        private List<String> fuzzyExt;

        public List<String> getFuzzyExt(){return this.fuzzyExt;}

        private List<String> rightFuzzyExt;

        public List<String> getRightFuzzyExt(){return this.rightFuzzyExt;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}


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

        public ConditionBuilder fuzzyAttentionOpenid (List<String> fuzzyAttentionOpenid){
            this.fuzzyAttentionOpenid = fuzzyAttentionOpenid;
            return this;
        }

        public ConditionBuilder fuzzyAttentionOpenid (String ... fuzzyAttentionOpenid){
            this.fuzzyAttentionOpenid = solveNullList(fuzzyAttentionOpenid);
            return this;
        }

        public ConditionBuilder rightFuzzyAttentionOpenid (List<String> rightFuzzyAttentionOpenid){
            this.rightFuzzyAttentionOpenid = rightFuzzyAttentionOpenid;
            return this;
        }

        public ConditionBuilder rightFuzzyAttentionOpenid (String ... rightFuzzyAttentionOpenid){
            this.rightFuzzyAttentionOpenid = solveNullList(rightFuzzyAttentionOpenid);
            return this;
        }

        public ConditionBuilder attentionOpenidList(String ... attentionOpenid){
            this.attentionOpenidList = solveNullList(attentionOpenid);
            return this;
        }

        public ConditionBuilder attentionOpenidList(List<String> attentionOpenid){
            this.attentionOpenidList = attentionOpenid;
            return this;
        }

        public ConditionBuilder attentionStatusBetWeen(Integer attentionStatusSt,Integer attentionStatusEd){
            this.attentionStatusSt = attentionStatusSt;
            this.attentionStatusEd = attentionStatusEd;
            return this;
        }

        public ConditionBuilder attentionStatusGreaterEqThan(Integer attentionStatusSt){
            this.attentionStatusSt = attentionStatusSt;
            return this;
        }
        public ConditionBuilder attentionStatusLessEqThan(Integer attentionStatusEd){
            this.attentionStatusEd = attentionStatusEd;
            return this;
        }


        public ConditionBuilder attentionStatusList(Integer ... attentionStatus){
            this.attentionStatusList = solveNullList(attentionStatus);
            return this;
        }

        public ConditionBuilder attentionStatusList(List<Integer> attentionStatus){
            this.attentionStatusList = attentionStatus;
            return this;
        }

        public ConditionBuilder fuzzyToAttentionOpenid (List<String> fuzzyToAttentionOpenid){
            this.fuzzyToAttentionOpenid = fuzzyToAttentionOpenid;
            return this;
        }

        public ConditionBuilder fuzzyToAttentionOpenid (String ... fuzzyToAttentionOpenid){
            this.fuzzyToAttentionOpenid = solveNullList(fuzzyToAttentionOpenid);
            return this;
        }

        public ConditionBuilder rightFuzzyToAttentionOpenid (List<String> rightFuzzyToAttentionOpenid){
            this.rightFuzzyToAttentionOpenid = rightFuzzyToAttentionOpenid;
            return this;
        }

        public ConditionBuilder rightFuzzyToAttentionOpenid (String ... rightFuzzyToAttentionOpenid){
            this.rightFuzzyToAttentionOpenid = solveNullList(rightFuzzyToAttentionOpenid);
            return this;
        }

        public ConditionBuilder toAttentionOpenidList(String ... toAttentionOpenid){
            this.toAttentionOpenidList = solveNullList(toAttentionOpenid);
            return this;
        }

        public ConditionBuilder toAttentionOpenidList(List<String> toAttentionOpenid){
            this.toAttentionOpenidList = toAttentionOpenid;
            return this;
        }

        public ConditionBuilder toAttentionStatusBetWeen(Integer toAttentionStatusSt,Integer toAttentionStatusEd){
            this.toAttentionStatusSt = toAttentionStatusSt;
            this.toAttentionStatusEd = toAttentionStatusEd;
            return this;
        }

        public ConditionBuilder toAttentionStatusGreaterEqThan(Integer toAttentionStatusSt){
            this.toAttentionStatusSt = toAttentionStatusSt;
            return this;
        }
        public ConditionBuilder toAttentionStatusLessEqThan(Integer toAttentionStatusEd){
            this.toAttentionStatusEd = toAttentionStatusEd;
            return this;
        }


        public ConditionBuilder toAttentionStatusList(Integer ... toAttentionStatus){
            this.toAttentionStatusList = solveNullList(toAttentionStatus);
            return this;
        }

        public ConditionBuilder toAttentionStatusList(List<Integer> toAttentionStatus){
            this.toAttentionStatusList = toAttentionStatus;
            return this;
        }

        public ConditionBuilder fuzzyExt (List<String> fuzzyExt){
            this.fuzzyExt = fuzzyExt;
            return this;
        }

        public ConditionBuilder fuzzyExt (String ... fuzzyExt){
            this.fuzzyExt = solveNullList(fuzzyExt);
            return this;
        }

        public ConditionBuilder rightFuzzyExt (List<String> rightFuzzyExt){
            this.rightFuzzyExt = rightFuzzyExt;
            return this;
        }

        public ConditionBuilder rightFuzzyExt (String ... rightFuzzyExt){
            this.rightFuzzyExt = solveNullList(rightFuzzyExt);
            return this;
        }

        public ConditionBuilder extList(String ... ext){
            this.extList = solveNullList(ext);
            return this;
        }

        public ConditionBuilder extList(List<String> ext){
            this.extList = ext;
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

        private AttentionInfo obj;

        public Builder(){
            this.obj = new AttentionInfo();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder attentionOpenid(String attentionOpenid){
            this.obj.setAttentionOpenid(attentionOpenid);
            return this;
        }
        public Builder attentionStatus(Integer attentionStatus){
            this.obj.setAttentionStatus(attentionStatus);
            return this;
        }
        public Builder toAttentionOpenid(String toAttentionOpenid){
            this.obj.setToAttentionOpenid(toAttentionOpenid);
            return this;
        }
        public Builder toAttentionStatus(Integer toAttentionStatus){
            this.obj.setToAttentionStatus(toAttentionStatus);
            return this;
        }
        public Builder ext(String ext){
            this.obj.setExt(ext);
            return this;
        }
        public Builder create(java.time.LocalDateTime create){
            this.obj.setCreate(create);
            return this;
        }
        public AttentionInfo build(){return obj;}
    }

}
