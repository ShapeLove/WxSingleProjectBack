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
public class Report implements Serializable {

    private static final long serialVersionUID = 1557813404324L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 举报者openid
    * isNullAble:0
    */
    private String openId;

    /**
    * 举报类型
    * isNullAble:0
    */
    private Integer reportType;

    /**
    * 被举报者openid
    * isNullAble:0
    */
    private String reportOpenId;

    /**
    * 
    * isNullAble:0,defaultVal:0000-00-00 00:00:00
    */
    private java.time.LocalDateTime create;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer status;

    /**
    * 
    * isNullAble:0,defaultVal:0000-00-00 00:00:00
    */
    private java.time.LocalDateTime modified;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setOpenId(String openId){this.openId = openId;}

    public String getOpenId(){return this.openId;}

    public void setReportType(Integer reportType){this.reportType = reportType;}

    public Integer getReportType(){return this.reportType;}

    public void setReportOpenId(String reportOpenId){this.reportOpenId = reportOpenId;}

    public String getReportOpenId(){return this.reportOpenId;}

    public void setCreate(java.time.LocalDateTime create){this.create = create;}

    public java.time.LocalDateTime getCreate(){return this.create;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}

    public void setModified(java.time.LocalDateTime modified){this.modified = modified;}

    public java.time.LocalDateTime getModified(){return this.modified;}
    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                "openId='" + openId + '\'' +
                "reportType='" + reportType + '\'' +
                "reportOpenId='" + reportOpenId + '\'' +
                "create='" + create + '\'' +
                "status='" + status + '\'' +
                "modified='" + modified + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Report set;

        private ConditionBuilder where;

        public UpdateBuilder set(Report set){
            this.set = set;
            return this;
        }

        public Report getSet(){
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

    public static class QueryBuilder extends Report{
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

        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
        private List<Integer> reportTypeList;

        public List<Integer> getReportTypeList(){return this.reportTypeList;}

        private Integer reportTypeSt;

        private Integer reportTypeEd;

        public Integer getReportTypeSt(){return this.reportTypeSt;}

        public Integer getReportTypeEd(){return this.reportTypeEd;}

        private List<String> reportOpenIdList;

        public List<String> getReportOpenIdList(){return this.reportOpenIdList;}


        private List<String> fuzzyReportOpenId;

        public List<String> getFuzzyReportOpenId(){return this.fuzzyReportOpenId;}

        private List<String> rightFuzzyReportOpenId;

        public List<String> getRightFuzzyReportOpenId(){return this.rightFuzzyReportOpenId;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<java.time.LocalDateTime> modifiedList;

        public List<java.time.LocalDateTime> getModifiedList(){return this.modifiedList;}

        private java.time.LocalDateTime modifiedSt;

        private java.time.LocalDateTime modifiedEd;

        public java.time.LocalDateTime getModifiedSt(){return this.modifiedSt;}

        public java.time.LocalDateTime getModifiedEd(){return this.modifiedEd;}

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

        public QueryBuilder reportTypeBetWeen(Integer reportTypeSt,Integer reportTypeEd){
            this.reportTypeSt = reportTypeSt;
            this.reportTypeEd = reportTypeEd;
            return this;
        }

        public QueryBuilder reportTypeGreaterEqThan(Integer reportTypeSt){
            this.reportTypeSt = reportTypeSt;
            return this;
        }
        public QueryBuilder reportTypeLessEqThan(Integer reportTypeEd){
            this.reportTypeEd = reportTypeEd;
            return this;
        }


        public QueryBuilder reportType(Integer reportType){
            setReportType(reportType);
            return this;
        }

        public QueryBuilder reportTypeList(Integer ... reportType){
            this.reportTypeList = solveNullList(reportType);
            return this;
        }

        public QueryBuilder reportTypeList(List<Integer> reportType){
            this.reportTypeList = reportType;
            return this;
        }

        public QueryBuilder fetchReportType(){
            setFetchFields("fetchFields","reportType");
            return this;
        }

        public QueryBuilder excludeReportType(){
            setFetchFields("excludeFields","reportType");
            return this;
        }

        public QueryBuilder fuzzyReportOpenId (List<String> fuzzyReportOpenId){
            this.fuzzyReportOpenId = fuzzyReportOpenId;
            return this;
        }

        public QueryBuilder fuzzyReportOpenId (String ... fuzzyReportOpenId){
            this.fuzzyReportOpenId = solveNullList(fuzzyReportOpenId);
            return this;
        }

        public QueryBuilder rightFuzzyReportOpenId (List<String> rightFuzzyReportOpenId){
            this.rightFuzzyReportOpenId = rightFuzzyReportOpenId;
            return this;
        }

        public QueryBuilder rightFuzzyReportOpenId (String ... rightFuzzyReportOpenId){
            this.rightFuzzyReportOpenId = solveNullList(rightFuzzyReportOpenId);
            return this;
        }

        public QueryBuilder reportOpenId(String reportOpenId){
            setReportOpenId(reportOpenId);
            return this;
        }

        public QueryBuilder reportOpenIdList(String ... reportOpenId){
            this.reportOpenIdList = solveNullList(reportOpenId);
            return this;
        }

        public QueryBuilder reportOpenIdList(List<String> reportOpenId){
            this.reportOpenIdList = reportOpenId;
            return this;
        }

        public QueryBuilder fetchReportOpenId(){
            setFetchFields("fetchFields","reportOpenId");
            return this;
        }

        public QueryBuilder excludeReportOpenId(){
            setFetchFields("excludeFields","reportOpenId");
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

        public QueryBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public QueryBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public QueryBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public QueryBuilder status(Integer status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<Integer> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
            return this;
        }

        public QueryBuilder modifiedBetWeen(java.time.LocalDateTime modifiedSt,java.time.LocalDateTime modifiedEd){
            this.modifiedSt = modifiedSt;
            this.modifiedEd = modifiedEd;
            return this;
        }

        public QueryBuilder modifiedGreaterEqThan(java.time.LocalDateTime modifiedSt){
            this.modifiedSt = modifiedSt;
            return this;
        }
        public QueryBuilder modifiedLessEqThan(java.time.LocalDateTime modifiedEd){
            this.modifiedEd = modifiedEd;
            return this;
        }


        public QueryBuilder modified(java.time.LocalDateTime modified){
            setModified(modified);
            return this;
        }

        public QueryBuilder modifiedList(java.time.LocalDateTime ... modified){
            this.modifiedList = solveNullList(modified);
            return this;
        }

        public QueryBuilder modifiedList(List<java.time.LocalDateTime> modified){
            this.modifiedList = modified;
            return this;
        }

        public QueryBuilder fetchModified(){
            setFetchFields("fetchFields","modified");
            return this;
        }

        public QueryBuilder excludeModified(){
            setFetchFields("excludeFields","modified");
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

        public Report build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
        private List<Integer> reportTypeList;

        public List<Integer> getReportTypeList(){return this.reportTypeList;}

        private Integer reportTypeSt;

        private Integer reportTypeEd;

        public Integer getReportTypeSt(){return this.reportTypeSt;}

        public Integer getReportTypeEd(){return this.reportTypeEd;}

        private List<String> reportOpenIdList;

        public List<String> getReportOpenIdList(){return this.reportOpenIdList;}


        private List<String> fuzzyReportOpenId;

        public List<String> getFuzzyReportOpenId(){return this.fuzzyReportOpenId;}

        private List<String> rightFuzzyReportOpenId;

        public List<String> getRightFuzzyReportOpenId(){return this.rightFuzzyReportOpenId;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<java.time.LocalDateTime> modifiedList;

        public List<java.time.LocalDateTime> getModifiedList(){return this.modifiedList;}

        private java.time.LocalDateTime modifiedSt;

        private java.time.LocalDateTime modifiedEd;

        public java.time.LocalDateTime getModifiedSt(){return this.modifiedSt;}

        public java.time.LocalDateTime getModifiedEd(){return this.modifiedEd;}


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

        public ConditionBuilder reportTypeBetWeen(Integer reportTypeSt,Integer reportTypeEd){
            this.reportTypeSt = reportTypeSt;
            this.reportTypeEd = reportTypeEd;
            return this;
        }

        public ConditionBuilder reportTypeGreaterEqThan(Integer reportTypeSt){
            this.reportTypeSt = reportTypeSt;
            return this;
        }
        public ConditionBuilder reportTypeLessEqThan(Integer reportTypeEd){
            this.reportTypeEd = reportTypeEd;
            return this;
        }


        public ConditionBuilder reportTypeList(Integer ... reportType){
            this.reportTypeList = solveNullList(reportType);
            return this;
        }

        public ConditionBuilder reportTypeList(List<Integer> reportType){
            this.reportTypeList = reportType;
            return this;
        }

        public ConditionBuilder fuzzyReportOpenId (List<String> fuzzyReportOpenId){
            this.fuzzyReportOpenId = fuzzyReportOpenId;
            return this;
        }

        public ConditionBuilder fuzzyReportOpenId (String ... fuzzyReportOpenId){
            this.fuzzyReportOpenId = solveNullList(fuzzyReportOpenId);
            return this;
        }

        public ConditionBuilder rightFuzzyReportOpenId (List<String> rightFuzzyReportOpenId){
            this.rightFuzzyReportOpenId = rightFuzzyReportOpenId;
            return this;
        }

        public ConditionBuilder rightFuzzyReportOpenId (String ... rightFuzzyReportOpenId){
            this.rightFuzzyReportOpenId = solveNullList(rightFuzzyReportOpenId);
            return this;
        }

        public ConditionBuilder reportOpenIdList(String ... reportOpenId){
            this.reportOpenIdList = solveNullList(reportOpenId);
            return this;
        }

        public ConditionBuilder reportOpenIdList(List<String> reportOpenId){
            this.reportOpenIdList = reportOpenId;
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

        public ConditionBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public ConditionBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public ConditionBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public ConditionBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<Integer> status){
            this.statusList = status;
            return this;
        }

        public ConditionBuilder modifiedBetWeen(java.time.LocalDateTime modifiedSt,java.time.LocalDateTime modifiedEd){
            this.modifiedSt = modifiedSt;
            this.modifiedEd = modifiedEd;
            return this;
        }

        public ConditionBuilder modifiedGreaterEqThan(java.time.LocalDateTime modifiedSt){
            this.modifiedSt = modifiedSt;
            return this;
        }
        public ConditionBuilder modifiedLessEqThan(java.time.LocalDateTime modifiedEd){
            this.modifiedEd = modifiedEd;
            return this;
        }


        public ConditionBuilder modifiedList(java.time.LocalDateTime ... modified){
            this.modifiedList = solveNullList(modified);
            return this;
        }

        public ConditionBuilder modifiedList(List<java.time.LocalDateTime> modified){
            this.modifiedList = modified;
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

        private Report obj;

        public Builder(){
            this.obj = new Report();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder openId(String openId){
            this.obj.setOpenId(openId);
            return this;
        }
        public Builder reportType(Integer reportType){
            this.obj.setReportType(reportType);
            return this;
        }
        public Builder reportOpenId(String reportOpenId){
            this.obj.setReportOpenId(reportOpenId);
            return this;
        }
        public Builder create(java.time.LocalDateTime create){
            this.obj.setCreate(create);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder modified(java.time.LocalDateTime modified){
            this.obj.setModified(modified);
            return this;
        }
        public Report build(){return obj;}
    }

}
