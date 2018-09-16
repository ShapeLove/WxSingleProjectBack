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
public class ExceptInfo implements Serializable {

    private static final long serialVersionUID = 1536944998119L;


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
    private String invocationName;

    /**
    * 
    * isNullAble:0,defaultVal:1
    */
    private Integer exceptNum;

    /**
    * 
    * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime createTime;

    /**
    * 
    * isNullAble:0,defaultVal:0000-00-00 00:00:00
    */
    private java.time.LocalDateTime modifiedTime;

    /**
    * 
    * isNullAble:0
    */
    private String lastExceptMessage;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setInvocationName(String invocationName){this.invocationName = invocationName;}

    public String getInvocationName(){return this.invocationName;}

    public void setExceptNum(Integer exceptNum){this.exceptNum = exceptNum;}

    public Integer getExceptNum(){return this.exceptNum;}

    public void setCreateTime(java.time.LocalDateTime createTime){this.createTime = createTime;}

    public java.time.LocalDateTime getCreateTime(){return this.createTime;}

    public void setModifiedTime(java.time.LocalDateTime modifiedTime){this.modifiedTime = modifiedTime;}

    public java.time.LocalDateTime getModifiedTime(){return this.modifiedTime;}

    public void setLastExceptMessage(String lastExceptMessage){this.lastExceptMessage = lastExceptMessage;}

    public String getLastExceptMessage(){return this.lastExceptMessage;}
    @Override
    public String toString() {
        return "ExceptInfo{" +
                "id='" + id + '\'' +
                "invocationName='" + invocationName + '\'' +
                "exceptNum='" + exceptNum + '\'' +
                "createTime='" + createTime + '\'' +
                "modifiedTime='" + modifiedTime + '\'' +
                "lastExceptMessage='" + lastExceptMessage + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private ExceptInfo set;

        private ConditionBuilder where;

        public UpdateBuilder set(ExceptInfo set){
            this.set = set;
            return this;
        }

        public ExceptInfo getSet(){
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

    public static class QueryBuilder extends ExceptInfo{
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

        private List<String> invocationNameList;

        public List<String> getInvocationNameList(){return this.invocationNameList;}


        private List<String> fuzzyInvocationName;

        public List<String> getFuzzyInvocationName(){return this.fuzzyInvocationName;}

        private List<String> rightFuzzyInvocationName;

        public List<String> getRightFuzzyInvocationName(){return this.rightFuzzyInvocationName;}
        private List<Integer> exceptNumList;

        public List<Integer> getExceptNumList(){return this.exceptNumList;}

        private Integer exceptNumSt;

        private Integer exceptNumEd;

        public Integer getExceptNumSt(){return this.exceptNumSt;}

        public Integer getExceptNumEd(){return this.exceptNumEd;}

        private List<java.time.LocalDateTime> createTimeList;

        public List<java.time.LocalDateTime> getCreateTimeList(){return this.createTimeList;}

        private java.time.LocalDateTime createTimeSt;

        private java.time.LocalDateTime createTimeEd;

        public java.time.LocalDateTime getCreateTimeSt(){return this.createTimeSt;}

        public java.time.LocalDateTime getCreateTimeEd(){return this.createTimeEd;}

        private List<java.time.LocalDateTime> modifiedTimeList;

        public List<java.time.LocalDateTime> getModifiedTimeList(){return this.modifiedTimeList;}

        private java.time.LocalDateTime modifiedTimeSt;

        private java.time.LocalDateTime modifiedTimeEd;

        public java.time.LocalDateTime getModifiedTimeSt(){return this.modifiedTimeSt;}

        public java.time.LocalDateTime getModifiedTimeEd(){return this.modifiedTimeEd;}

        private List<String> lastExceptMessageList;

        public List<String> getLastExceptMessageList(){return this.lastExceptMessageList;}


        private List<String> fuzzyLastExceptMessage;

        public List<String> getFuzzyLastExceptMessage(){return this.fuzzyLastExceptMessage;}

        private List<String> rightFuzzyLastExceptMessage;

        public List<String> getRightFuzzyLastExceptMessage(){return this.rightFuzzyLastExceptMessage;}
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

        public QueryBuilder fuzzyInvocationName (List<String> fuzzyInvocationName){
            this.fuzzyInvocationName = fuzzyInvocationName;
            return this;
        }

        public QueryBuilder fuzzyInvocationName (String ... fuzzyInvocationName){
            this.fuzzyInvocationName = solveNullList(fuzzyInvocationName);
            return this;
        }

        public QueryBuilder rightFuzzyInvocationName (List<String> rightFuzzyInvocationName){
            this.rightFuzzyInvocationName = rightFuzzyInvocationName;
            return this;
        }

        public QueryBuilder rightFuzzyInvocationName (String ... rightFuzzyInvocationName){
            this.rightFuzzyInvocationName = solveNullList(rightFuzzyInvocationName);
            return this;
        }

        public QueryBuilder invocationName(String invocationName){
            setInvocationName(invocationName);
            return this;
        }

        public QueryBuilder invocationNameList(String ... invocationName){
            this.invocationNameList = solveNullList(invocationName);
            return this;
        }

        public QueryBuilder invocationNameList(List<String> invocationName){
            this.invocationNameList = invocationName;
            return this;
        }

        public QueryBuilder fetchInvocationName(){
            setFetchFields("fetchFields","invocationName");
            return this;
        }

        public QueryBuilder excludeInvocationName(){
            setFetchFields("excludeFields","invocationName");
            return this;
        }

        public QueryBuilder exceptNumBetWeen(Integer exceptNumSt,Integer exceptNumEd){
            this.exceptNumSt = exceptNumSt;
            this.exceptNumEd = exceptNumEd;
            return this;
        }

        public QueryBuilder exceptNumGreaterEqThan(Integer exceptNumSt){
            this.exceptNumSt = exceptNumSt;
            return this;
        }
        public QueryBuilder exceptNumLessEqThan(Integer exceptNumEd){
            this.exceptNumEd = exceptNumEd;
            return this;
        }


        public QueryBuilder exceptNum(Integer exceptNum){
            setExceptNum(exceptNum);
            return this;
        }

        public QueryBuilder exceptNumList(Integer ... exceptNum){
            this.exceptNumList = solveNullList(exceptNum);
            return this;
        }

        public QueryBuilder exceptNumList(List<Integer> exceptNum){
            this.exceptNumList = exceptNum;
            return this;
        }

        public QueryBuilder fetchExceptNum(){
            setFetchFields("fetchFields","exceptNum");
            return this;
        }

        public QueryBuilder excludeExceptNum(){
            setFetchFields("excludeFields","exceptNum");
            return this;
        }

        public QueryBuilder createTimeBetWeen(java.time.LocalDateTime createTimeSt,java.time.LocalDateTime createTimeEd){
            this.createTimeSt = createTimeSt;
            this.createTimeEd = createTimeEd;
            return this;
        }

        public QueryBuilder createTimeGreaterEqThan(java.time.LocalDateTime createTimeSt){
            this.createTimeSt = createTimeSt;
            return this;
        }
        public QueryBuilder createTimeLessEqThan(java.time.LocalDateTime createTimeEd){
            this.createTimeEd = createTimeEd;
            return this;
        }


        public QueryBuilder createTime(java.time.LocalDateTime createTime){
            setCreateTime(createTime);
            return this;
        }

        public QueryBuilder createTimeList(java.time.LocalDateTime ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public QueryBuilder createTimeList(List<java.time.LocalDateTime> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public QueryBuilder fetchCreateTime(){
            setFetchFields("fetchFields","createTime");
            return this;
        }

        public QueryBuilder excludeCreateTime(){
            setFetchFields("excludeFields","createTime");
            return this;
        }

        public QueryBuilder modifiedTimeBetWeen(java.time.LocalDateTime modifiedTimeSt,java.time.LocalDateTime modifiedTimeEd){
            this.modifiedTimeSt = modifiedTimeSt;
            this.modifiedTimeEd = modifiedTimeEd;
            return this;
        }

        public QueryBuilder modifiedTimeGreaterEqThan(java.time.LocalDateTime modifiedTimeSt){
            this.modifiedTimeSt = modifiedTimeSt;
            return this;
        }
        public QueryBuilder modifiedTimeLessEqThan(java.time.LocalDateTime modifiedTimeEd){
            this.modifiedTimeEd = modifiedTimeEd;
            return this;
        }


        public QueryBuilder modifiedTime(java.time.LocalDateTime modifiedTime){
            setModifiedTime(modifiedTime);
            return this;
        }

        public QueryBuilder modifiedTimeList(java.time.LocalDateTime ... modifiedTime){
            this.modifiedTimeList = solveNullList(modifiedTime);
            return this;
        }

        public QueryBuilder modifiedTimeList(List<java.time.LocalDateTime> modifiedTime){
            this.modifiedTimeList = modifiedTime;
            return this;
        }

        public QueryBuilder fetchModifiedTime(){
            setFetchFields("fetchFields","modifiedTime");
            return this;
        }

        public QueryBuilder excludeModifiedTime(){
            setFetchFields("excludeFields","modifiedTime");
            return this;
        }

        public QueryBuilder fuzzyLastExceptMessage (List<String> fuzzyLastExceptMessage){
            this.fuzzyLastExceptMessage = fuzzyLastExceptMessage;
            return this;
        }

        public QueryBuilder fuzzyLastExceptMessage (String ... fuzzyLastExceptMessage){
            this.fuzzyLastExceptMessage = solveNullList(fuzzyLastExceptMessage);
            return this;
        }

        public QueryBuilder rightFuzzyLastExceptMessage (List<String> rightFuzzyLastExceptMessage){
            this.rightFuzzyLastExceptMessage = rightFuzzyLastExceptMessage;
            return this;
        }

        public QueryBuilder rightFuzzyLastExceptMessage (String ... rightFuzzyLastExceptMessage){
            this.rightFuzzyLastExceptMessage = solveNullList(rightFuzzyLastExceptMessage);
            return this;
        }

        public QueryBuilder lastExceptMessage(String lastExceptMessage){
            setLastExceptMessage(lastExceptMessage);
            return this;
        }

        public QueryBuilder lastExceptMessageList(String ... lastExceptMessage){
            this.lastExceptMessageList = solveNullList(lastExceptMessage);
            return this;
        }

        public QueryBuilder lastExceptMessageList(List<String> lastExceptMessage){
            this.lastExceptMessageList = lastExceptMessage;
            return this;
        }

        public QueryBuilder fetchLastExceptMessage(){
            setFetchFields("fetchFields","lastExceptMessage");
            return this;
        }

        public QueryBuilder excludeLastExceptMessage(){
            setFetchFields("excludeFields","lastExceptMessage");
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

        public ExceptInfo build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> invocationNameList;

        public List<String> getInvocationNameList(){return this.invocationNameList;}


        private List<String> fuzzyInvocationName;

        public List<String> getFuzzyInvocationName(){return this.fuzzyInvocationName;}

        private List<String> rightFuzzyInvocationName;

        public List<String> getRightFuzzyInvocationName(){return this.rightFuzzyInvocationName;}
        private List<Integer> exceptNumList;

        public List<Integer> getExceptNumList(){return this.exceptNumList;}

        private Integer exceptNumSt;

        private Integer exceptNumEd;

        public Integer getExceptNumSt(){return this.exceptNumSt;}

        public Integer getExceptNumEd(){return this.exceptNumEd;}

        private List<java.time.LocalDateTime> createTimeList;

        public List<java.time.LocalDateTime> getCreateTimeList(){return this.createTimeList;}

        private java.time.LocalDateTime createTimeSt;

        private java.time.LocalDateTime createTimeEd;

        public java.time.LocalDateTime getCreateTimeSt(){return this.createTimeSt;}

        public java.time.LocalDateTime getCreateTimeEd(){return this.createTimeEd;}

        private List<java.time.LocalDateTime> modifiedTimeList;

        public List<java.time.LocalDateTime> getModifiedTimeList(){return this.modifiedTimeList;}

        private java.time.LocalDateTime modifiedTimeSt;

        private java.time.LocalDateTime modifiedTimeEd;

        public java.time.LocalDateTime getModifiedTimeSt(){return this.modifiedTimeSt;}

        public java.time.LocalDateTime getModifiedTimeEd(){return this.modifiedTimeEd;}

        private List<String> lastExceptMessageList;

        public List<String> getLastExceptMessageList(){return this.lastExceptMessageList;}


        private List<String> fuzzyLastExceptMessage;

        public List<String> getFuzzyLastExceptMessage(){return this.fuzzyLastExceptMessage;}

        private List<String> rightFuzzyLastExceptMessage;

        public List<String> getRightFuzzyLastExceptMessage(){return this.rightFuzzyLastExceptMessage;}

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

        public ConditionBuilder fuzzyInvocationName (List<String> fuzzyInvocationName){
            this.fuzzyInvocationName = fuzzyInvocationName;
            return this;
        }

        public ConditionBuilder fuzzyInvocationName (String ... fuzzyInvocationName){
            this.fuzzyInvocationName = solveNullList(fuzzyInvocationName);
            return this;
        }

        public ConditionBuilder rightFuzzyInvocationName (List<String> rightFuzzyInvocationName){
            this.rightFuzzyInvocationName = rightFuzzyInvocationName;
            return this;
        }

        public ConditionBuilder rightFuzzyInvocationName (String ... rightFuzzyInvocationName){
            this.rightFuzzyInvocationName = solveNullList(rightFuzzyInvocationName);
            return this;
        }

        public ConditionBuilder invocationNameList(String ... invocationName){
            this.invocationNameList = solveNullList(invocationName);
            return this;
        }

        public ConditionBuilder invocationNameList(List<String> invocationName){
            this.invocationNameList = invocationName;
            return this;
        }

        public ConditionBuilder exceptNumBetWeen(Integer exceptNumSt,Integer exceptNumEd){
            this.exceptNumSt = exceptNumSt;
            this.exceptNumEd = exceptNumEd;
            return this;
        }

        public ConditionBuilder exceptNumGreaterEqThan(Integer exceptNumSt){
            this.exceptNumSt = exceptNumSt;
            return this;
        }
        public ConditionBuilder exceptNumLessEqThan(Integer exceptNumEd){
            this.exceptNumEd = exceptNumEd;
            return this;
        }


        public ConditionBuilder exceptNumList(Integer ... exceptNum){
            this.exceptNumList = solveNullList(exceptNum);
            return this;
        }

        public ConditionBuilder exceptNumList(List<Integer> exceptNum){
            this.exceptNumList = exceptNum;
            return this;
        }

        public ConditionBuilder createTimeBetWeen(java.time.LocalDateTime createTimeSt,java.time.LocalDateTime createTimeEd){
            this.createTimeSt = createTimeSt;
            this.createTimeEd = createTimeEd;
            return this;
        }

        public ConditionBuilder createTimeGreaterEqThan(java.time.LocalDateTime createTimeSt){
            this.createTimeSt = createTimeSt;
            return this;
        }
        public ConditionBuilder createTimeLessEqThan(java.time.LocalDateTime createTimeEd){
            this.createTimeEd = createTimeEd;
            return this;
        }


        public ConditionBuilder createTimeList(java.time.LocalDateTime ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public ConditionBuilder createTimeList(List<java.time.LocalDateTime> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public ConditionBuilder modifiedTimeBetWeen(java.time.LocalDateTime modifiedTimeSt,java.time.LocalDateTime modifiedTimeEd){
            this.modifiedTimeSt = modifiedTimeSt;
            this.modifiedTimeEd = modifiedTimeEd;
            return this;
        }

        public ConditionBuilder modifiedTimeGreaterEqThan(java.time.LocalDateTime modifiedTimeSt){
            this.modifiedTimeSt = modifiedTimeSt;
            return this;
        }
        public ConditionBuilder modifiedTimeLessEqThan(java.time.LocalDateTime modifiedTimeEd){
            this.modifiedTimeEd = modifiedTimeEd;
            return this;
        }


        public ConditionBuilder modifiedTimeList(java.time.LocalDateTime ... modifiedTime){
            this.modifiedTimeList = solveNullList(modifiedTime);
            return this;
        }

        public ConditionBuilder modifiedTimeList(List<java.time.LocalDateTime> modifiedTime){
            this.modifiedTimeList = modifiedTime;
            return this;
        }

        public ConditionBuilder fuzzyLastExceptMessage (List<String> fuzzyLastExceptMessage){
            this.fuzzyLastExceptMessage = fuzzyLastExceptMessage;
            return this;
        }

        public ConditionBuilder fuzzyLastExceptMessage (String ... fuzzyLastExceptMessage){
            this.fuzzyLastExceptMessage = solveNullList(fuzzyLastExceptMessage);
            return this;
        }

        public ConditionBuilder rightFuzzyLastExceptMessage (List<String> rightFuzzyLastExceptMessage){
            this.rightFuzzyLastExceptMessage = rightFuzzyLastExceptMessage;
            return this;
        }

        public ConditionBuilder rightFuzzyLastExceptMessage (String ... rightFuzzyLastExceptMessage){
            this.rightFuzzyLastExceptMessage = solveNullList(rightFuzzyLastExceptMessage);
            return this;
        }

        public ConditionBuilder lastExceptMessageList(String ... lastExceptMessage){
            this.lastExceptMessageList = solveNullList(lastExceptMessage);
            return this;
        }

        public ConditionBuilder lastExceptMessageList(List<String> lastExceptMessage){
            this.lastExceptMessageList = lastExceptMessage;
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

        private ExceptInfo obj;

        public Builder(){
            this.obj = new ExceptInfo();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder invocationName(String invocationName){
            this.obj.setInvocationName(invocationName);
            return this;
        }
        public Builder exceptNum(Integer exceptNum){
            this.obj.setExceptNum(exceptNum);
            return this;
        }
        public Builder createTime(java.time.LocalDateTime createTime){
            this.obj.setCreateTime(createTime);
            return this;
        }
        public Builder modifiedTime(java.time.LocalDateTime modifiedTime){
            this.obj.setModifiedTime(modifiedTime);
            return this;
        }
        public Builder lastExceptMessage(String lastExceptMessage){
            this.obj.setLastExceptMessage(lastExceptMessage);
            return this;
        }
        public ExceptInfo build(){return obj;}
    }

}
