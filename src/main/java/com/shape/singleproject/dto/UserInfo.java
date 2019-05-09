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

    private static final long serialVersionUID = 1557403934812L;


    /**
    * 主键
    * 自增标识
    * isNullAble:0
    */
    private Long id;

    /**
    * 微信唯一标识
    * isNullAble:0
    */
    private String openId;

    /**
    * 昵称
    * isNullAble:0
    */
    private String name;

    /**
    * 是否有效
    * isNullAble:0,defaultVal:0
    */
    private Integer yn;

    /**
    * 星座枚举
    * isNullAble:1
    */
    private Integer constellation;

    /**
    * 出生日期
    * isNullAble:1
    */
    private java.time.LocalDate birthday;

    /**
    * 学历枚举
    * isNullAble:1
    */
    private Integer education;

    /**
    * 性别枚举
    * isNullAble:1
    */
    private Integer sex;

    /**
    * 籍贯省地址
    * isNullAble:1
    */
    private String province;

    /**
    * 籍贯市地址
    * isNullAble:1
    */
    private String city;

    /**
    * 爱好
    * isNullAble:1
    */
    private String hobby;

    /**
    * 身高
    * isNullAble:1
    */
    private Integer height;

    /**
    * 体重
    * isNullAble:1
    */
    private Integer weight;

    /**
    * 自我评价
    * isNullAble:1
    */
    private String selfEvaluation;

    /**
    * 工作地区
    * isNullAble:1
    */
    private String workArea;

    /**
    * 最想说的
    * isNullAble:1
    */
    private String wantSay;

    /**
    * 家庭情况
    * isNullAble:1
    */
    private String family;

    /**
    * 交友标准
    * isNullAble:1
    */
    private String standFriend;

    /**
    * 个人图片
    * isNullAble:1
    */
    private String photos;

    /**
    * 部门信息
    * isNullAble:1
    */
    private String department;

    /**
    * 审核状态
    * isNullAble:0,defaultVal:0
    */
    private Integer status;

    /**
    * 驳回原因
    * isNullAble:1
    */
    private String rejectReason;

    /**
    * 咚咚号
    * isNullAble:1
    */
    private String dongdong;

    /**
    * 微信号
    * isNullAble:1
    */
    private String wxNumber;

    /**
    * 创建时间
    * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime create;

    /**
    * 修改时间
    * isNullAble:0,defaultVal:0000-00-00 00:00:00
    */
    private java.time.LocalDateTime modified;

    /**
    * 冗余字段
    * isNullAble:1
    */
    private String ext;

    /**
    * 正在做标签
    * isNullAble:1
    */
    private String doingTags;

    /**
    * 打算做标签
    * isNullAble:1
    */
    private String planTags;

    /**
    * 活动标签
    * isNullAble:1
    */
    private String activityTags;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setOpenId(String openId){this.openId = openId;}

    public String getOpenId(){return this.openId;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setYn(Integer yn){this.yn = yn;}

    public Integer getYn(){return this.yn;}

    public void setConstellation(Integer constellation){this.constellation = constellation;}

    public Integer getConstellation(){return this.constellation;}

    public void setBirthday(java.time.LocalDate birthday){this.birthday = birthday;}

    public java.time.LocalDate getBirthday(){return this.birthday;}

    public void setEducation(Integer education){this.education = education;}

    public Integer getEducation(){return this.education;}

    public void setSex(Integer sex){this.sex = sex;}

    public Integer getSex(){return this.sex;}

    public void setProvince(String province){this.province = province;}

    public String getProvince(){return this.province;}

    public void setCity(String city){this.city = city;}

    public String getCity(){return this.city;}

    public void setHobby(String hobby){this.hobby = hobby;}

    public String getHobby(){return this.hobby;}

    public void setHeight(Integer height){this.height = height;}

    public Integer getHeight(){return this.height;}

    public void setWeight(Integer weight){this.weight = weight;}

    public Integer getWeight(){return this.weight;}

    public void setSelfEvaluation(String selfEvaluation){this.selfEvaluation = selfEvaluation;}

    public String getSelfEvaluation(){return this.selfEvaluation;}

    public void setWorkArea(String workArea){this.workArea = workArea;}

    public String getWorkArea(){return this.workArea;}

    public void setWantSay(String wantSay){this.wantSay = wantSay;}

    public String getWantSay(){return this.wantSay;}

    public void setFamily(String family){this.family = family;}

    public String getFamily(){return this.family;}

    public void setStandFriend(String standFriend){this.standFriend = standFriend;}

    public String getStandFriend(){return this.standFriend;}

    public void setPhotos(String photos){this.photos = photos;}

    public String getPhotos(){return this.photos;}

    public void setDepartment(String department){this.department = department;}

    public String getDepartment(){return this.department;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}

    public void setRejectReason(String rejectReason){this.rejectReason = rejectReason;}

    public String getRejectReason(){return this.rejectReason;}

    public void setDongdong(String dongdong){this.dongdong = dongdong;}

    public String getDongdong(){return this.dongdong;}

    public void setWxNumber(String wxNumber){this.wxNumber = wxNumber;}

    public String getWxNumber(){return this.wxNumber;}

    public void setCreate(java.time.LocalDateTime create){this.create = create;}

    public java.time.LocalDateTime getCreate(){return this.create;}

    public void setModified(java.time.LocalDateTime modified){this.modified = modified;}

    public java.time.LocalDateTime getModified(){return this.modified;}

    public void setExt(String ext){this.ext = ext;}

    public String getExt(){return this.ext;}

    public void setDoingTags(String doingTags){this.doingTags = doingTags;}

    public String getDoingTags(){return this.doingTags;}

    public void setPlanTags(String planTags){this.planTags = planTags;}

    public String getPlanTags(){return this.planTags;}

    public void setActivityTags(String activityTags){this.activityTags = activityTags;}

    public String getActivityTags(){return this.activityTags;}
    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                "openId='" + openId + '\'' +
                "name='" + name + '\'' +
                "yn='" + yn + '\'' +
                "constellation='" + constellation + '\'' +
                "birthday='" + birthday + '\'' +
                "education='" + education + '\'' +
                "sex='" + sex + '\'' +
                "province='" + province + '\'' +
                "city='" + city + '\'' +
                "hobby='" + hobby + '\'' +
                "height='" + height + '\'' +
                "weight='" + weight + '\'' +
                "selfEvaluation='" + selfEvaluation + '\'' +
                "workArea='" + workArea + '\'' +
                "wantSay='" + wantSay + '\'' +
                "family='" + family + '\'' +
                "standFriend='" + standFriend + '\'' +
                "photos='" + photos + '\'' +
                "department='" + department + '\'' +
                "status='" + status + '\'' +
                "rejectReason='" + rejectReason + '\'' +
                "dongdong='" + dongdong + '\'' +
                "wxNumber='" + wxNumber + '\'' +
                "create='" + create + '\'' +
                "modified='" + modified + '\'' +
                "ext='" + ext + '\'' +
                "doingTags='" + doingTags + '\'' +
                "planTags='" + planTags + '\'' +
                "activityTags='" + activityTags + '\'' +
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

        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
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

        private List<Integer> constellationList;

        public List<Integer> getConstellationList(){return this.constellationList;}

        private Integer constellationSt;

        private Integer constellationEd;

        public Integer getConstellationSt(){return this.constellationSt;}

        public Integer getConstellationEd(){return this.constellationEd;}

        private List<java.time.LocalDate> birthdayList;

        public List<java.time.LocalDate> getBirthdayList(){return this.birthdayList;}

        private java.time.LocalDate birthdaySt;

        private java.time.LocalDate birthdayEd;

        public java.time.LocalDate getBirthdaySt(){return this.birthdaySt;}

        public java.time.LocalDate getBirthdayEd(){return this.birthdayEd;}

        private List<Integer> educationList;

        public List<Integer> getEducationList(){return this.educationList;}

        private Integer educationSt;

        private Integer educationEd;

        public Integer getEducationSt(){return this.educationSt;}

        public Integer getEducationEd(){return this.educationEd;}

        private List<Integer> sexList;

        public List<Integer> getSexList(){return this.sexList;}

        private Integer sexSt;

        private Integer sexEd;

        public Integer getSexSt(){return this.sexSt;}

        public Integer getSexEd(){return this.sexEd;}

        private List<String> provinceList;

        public List<String> getProvinceList(){return this.provinceList;}


        private List<String> fuzzyProvince;

        public List<String> getFuzzyProvince(){return this.fuzzyProvince;}

        private List<String> rightFuzzyProvince;

        public List<String> getRightFuzzyProvince(){return this.rightFuzzyProvince;}
        private List<String> cityList;

        public List<String> getCityList(){return this.cityList;}


        private List<String> fuzzyCity;

        public List<String> getFuzzyCity(){return this.fuzzyCity;}

        private List<String> rightFuzzyCity;

        public List<String> getRightFuzzyCity(){return this.rightFuzzyCity;}
        private List<String> hobbyList;

        public List<String> getHobbyList(){return this.hobbyList;}


        private List<String> fuzzyHobby;

        public List<String> getFuzzyHobby(){return this.fuzzyHobby;}

        private List<String> rightFuzzyHobby;

        public List<String> getRightFuzzyHobby(){return this.rightFuzzyHobby;}
        private List<Integer> heightList;

        public List<Integer> getHeightList(){return this.heightList;}

        private Integer heightSt;

        private Integer heightEd;

        public Integer getHeightSt(){return this.heightSt;}

        public Integer getHeightEd(){return this.heightEd;}

        private List<Integer> weightList;

        public List<Integer> getWeightList(){return this.weightList;}

        private Integer weightSt;

        private Integer weightEd;

        public Integer getWeightSt(){return this.weightSt;}

        public Integer getWeightEd(){return this.weightEd;}

        private List<String> selfEvaluationList;

        public List<String> getSelfEvaluationList(){return this.selfEvaluationList;}


        private List<String> fuzzySelfEvaluation;

        public List<String> getFuzzySelfEvaluation(){return this.fuzzySelfEvaluation;}

        private List<String> rightFuzzySelfEvaluation;

        public List<String> getRightFuzzySelfEvaluation(){return this.rightFuzzySelfEvaluation;}
        private List<String> workAreaList;

        public List<String> getWorkAreaList(){return this.workAreaList;}


        private List<String> fuzzyWorkArea;

        public List<String> getFuzzyWorkArea(){return this.fuzzyWorkArea;}

        private List<String> rightFuzzyWorkArea;

        public List<String> getRightFuzzyWorkArea(){return this.rightFuzzyWorkArea;}
        private List<String> wantSayList;

        public List<String> getWantSayList(){return this.wantSayList;}


        private List<String> fuzzyWantSay;

        public List<String> getFuzzyWantSay(){return this.fuzzyWantSay;}

        private List<String> rightFuzzyWantSay;

        public List<String> getRightFuzzyWantSay(){return this.rightFuzzyWantSay;}
        private List<String> familyList;

        public List<String> getFamilyList(){return this.familyList;}


        private List<String> fuzzyFamily;

        public List<String> getFuzzyFamily(){return this.fuzzyFamily;}

        private List<String> rightFuzzyFamily;

        public List<String> getRightFuzzyFamily(){return this.rightFuzzyFamily;}
        private List<String> standFriendList;

        public List<String> getStandFriendList(){return this.standFriendList;}


        private List<String> fuzzyStandFriend;

        public List<String> getFuzzyStandFriend(){return this.fuzzyStandFriend;}

        private List<String> rightFuzzyStandFriend;

        public List<String> getRightFuzzyStandFriend(){return this.rightFuzzyStandFriend;}
        private List<String> photosList;

        public List<String> getPhotosList(){return this.photosList;}


        private List<String> fuzzyPhotos;

        public List<String> getFuzzyPhotos(){return this.fuzzyPhotos;}

        private List<String> rightFuzzyPhotos;

        public List<String> getRightFuzzyPhotos(){return this.rightFuzzyPhotos;}
        private List<String> departmentList;

        public List<String> getDepartmentList(){return this.departmentList;}


        private List<String> fuzzyDepartment;

        public List<String> getFuzzyDepartment(){return this.fuzzyDepartment;}

        private List<String> rightFuzzyDepartment;

        public List<String> getRightFuzzyDepartment(){return this.rightFuzzyDepartment;}
        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> rejectReasonList;

        public List<String> getRejectReasonList(){return this.rejectReasonList;}


        private List<String> fuzzyRejectReason;

        public List<String> getFuzzyRejectReason(){return this.fuzzyRejectReason;}

        private List<String> rightFuzzyRejectReason;

        public List<String> getRightFuzzyRejectReason(){return this.rightFuzzyRejectReason;}
        private List<String> dongdongList;

        public List<String> getDongdongList(){return this.dongdongList;}


        private List<String> fuzzyDongdong;

        public List<String> getFuzzyDongdong(){return this.fuzzyDongdong;}

        private List<String> rightFuzzyDongdong;

        public List<String> getRightFuzzyDongdong(){return this.rightFuzzyDongdong;}
        private List<String> wxNumberList;

        public List<String> getWxNumberList(){return this.wxNumberList;}


        private List<String> fuzzyWxNumber;

        public List<String> getFuzzyWxNumber(){return this.fuzzyWxNumber;}

        private List<String> rightFuzzyWxNumber;

        public List<String> getRightFuzzyWxNumber(){return this.rightFuzzyWxNumber;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<java.time.LocalDateTime> modifiedList;

        public List<java.time.LocalDateTime> getModifiedList(){return this.modifiedList;}

        private java.time.LocalDateTime modifiedSt;

        private java.time.LocalDateTime modifiedEd;

        public java.time.LocalDateTime getModifiedSt(){return this.modifiedSt;}

        public java.time.LocalDateTime getModifiedEd(){return this.modifiedEd;}

        private List<String> extList;

        public List<String> getExtList(){return this.extList;}


        private List<String> fuzzyExt;

        public List<String> getFuzzyExt(){return this.fuzzyExt;}

        private List<String> rightFuzzyExt;

        public List<String> getRightFuzzyExt(){return this.rightFuzzyExt;}
        private List<String> doingTagsList;

        public List<String> getDoingTagsList(){return this.doingTagsList;}


        private List<String> fuzzyDoingTags;

        public List<String> getFuzzyDoingTags(){return this.fuzzyDoingTags;}

        private List<String> rightFuzzyDoingTags;

        public List<String> getRightFuzzyDoingTags(){return this.rightFuzzyDoingTags;}
        private List<String> planTagsList;

        public List<String> getPlanTagsList(){return this.planTagsList;}


        private List<String> fuzzyPlanTags;

        public List<String> getFuzzyPlanTags(){return this.fuzzyPlanTags;}

        private List<String> rightFuzzyPlanTags;

        public List<String> getRightFuzzyPlanTags(){return this.rightFuzzyPlanTags;}
        private List<String> activityTagsList;

        public List<String> getActivityTagsList(){return this.activityTagsList;}


        private List<String> fuzzyActivityTags;

        public List<String> getFuzzyActivityTags(){return this.fuzzyActivityTags;}

        private List<String> rightFuzzyActivityTags;

        public List<String> getRightFuzzyActivityTags(){return this.rightFuzzyActivityTags;}
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

        public QueryBuilder constellationBetWeen(Integer constellationSt,Integer constellationEd){
            this.constellationSt = constellationSt;
            this.constellationEd = constellationEd;
            return this;
        }

        public QueryBuilder constellationGreaterEqThan(Integer constellationSt){
            this.constellationSt = constellationSt;
            return this;
        }
        public QueryBuilder constellationLessEqThan(Integer constellationEd){
            this.constellationEd = constellationEd;
            return this;
        }


        public QueryBuilder constellation(Integer constellation){
            setConstellation(constellation);
            return this;
        }

        public QueryBuilder constellationList(Integer ... constellation){
            this.constellationList = solveNullList(constellation);
            return this;
        }

        public QueryBuilder constellationList(List<Integer> constellation){
            this.constellationList = constellation;
            return this;
        }

        public QueryBuilder fetchConstellation(){
            setFetchFields("fetchFields","constellation");
            return this;
        }

        public QueryBuilder excludeConstellation(){
            setFetchFields("excludeFields","constellation");
            return this;
        }

        public QueryBuilder birthdayBetWeen(java.time.LocalDate birthdaySt,java.time.LocalDate birthdayEd){
            this.birthdaySt = birthdaySt;
            this.birthdayEd = birthdayEd;
            return this;
        }

        public QueryBuilder birthdayGreaterEqThan(java.time.LocalDate birthdaySt){
            this.birthdaySt = birthdaySt;
            return this;
        }
        public QueryBuilder birthdayLessEqThan(java.time.LocalDate birthdayEd){
            this.birthdayEd = birthdayEd;
            return this;
        }


        public QueryBuilder birthday(java.time.LocalDate birthday){
            setBirthday(birthday);
            return this;
        }

        public QueryBuilder birthdayList(java.time.LocalDate ... birthday){
            this.birthdayList = solveNullList(birthday);
            return this;
        }

        public QueryBuilder birthdayList(List<java.time.LocalDate> birthday){
            this.birthdayList = birthday;
            return this;
        }

        public QueryBuilder fetchBirthday(){
            setFetchFields("fetchFields","birthday");
            return this;
        }

        public QueryBuilder excludeBirthday(){
            setFetchFields("excludeFields","birthday");
            return this;
        }

        public QueryBuilder educationBetWeen(Integer educationSt,Integer educationEd){
            this.educationSt = educationSt;
            this.educationEd = educationEd;
            return this;
        }

        public QueryBuilder educationGreaterEqThan(Integer educationSt){
            this.educationSt = educationSt;
            return this;
        }
        public QueryBuilder educationLessEqThan(Integer educationEd){
            this.educationEd = educationEd;
            return this;
        }


        public QueryBuilder education(Integer education){
            setEducation(education);
            return this;
        }

        public QueryBuilder educationList(Integer ... education){
            this.educationList = solveNullList(education);
            return this;
        }

        public QueryBuilder educationList(List<Integer> education){
            this.educationList = education;
            return this;
        }

        public QueryBuilder fetchEducation(){
            setFetchFields("fetchFields","education");
            return this;
        }

        public QueryBuilder excludeEducation(){
            setFetchFields("excludeFields","education");
            return this;
        }

        public QueryBuilder sexBetWeen(Integer sexSt,Integer sexEd){
            this.sexSt = sexSt;
            this.sexEd = sexEd;
            return this;
        }

        public QueryBuilder sexGreaterEqThan(Integer sexSt){
            this.sexSt = sexSt;
            return this;
        }
        public QueryBuilder sexLessEqThan(Integer sexEd){
            this.sexEd = sexEd;
            return this;
        }


        public QueryBuilder sex(Integer sex){
            setSex(sex);
            return this;
        }

        public QueryBuilder sexList(Integer ... sex){
            this.sexList = solveNullList(sex);
            return this;
        }

        public QueryBuilder sexList(List<Integer> sex){
            this.sexList = sex;
            return this;
        }

        public QueryBuilder fetchSex(){
            setFetchFields("fetchFields","sex");
            return this;
        }

        public QueryBuilder excludeSex(){
            setFetchFields("excludeFields","sex");
            return this;
        }

        public QueryBuilder fuzzyProvince (List<String> fuzzyProvince){
            this.fuzzyProvince = fuzzyProvince;
            return this;
        }

        public QueryBuilder fuzzyProvince (String ... fuzzyProvince){
            this.fuzzyProvince = solveNullList(fuzzyProvince);
            return this;
        }

        public QueryBuilder rightFuzzyProvince (List<String> rightFuzzyProvince){
            this.rightFuzzyProvince = rightFuzzyProvince;
            return this;
        }

        public QueryBuilder rightFuzzyProvince (String ... rightFuzzyProvince){
            this.rightFuzzyProvince = solveNullList(rightFuzzyProvince);
            return this;
        }

        public QueryBuilder province(String province){
            setProvince(province);
            return this;
        }

        public QueryBuilder provinceList(String ... province){
            this.provinceList = solveNullList(province);
            return this;
        }

        public QueryBuilder provinceList(List<String> province){
            this.provinceList = province;
            return this;
        }

        public QueryBuilder fetchProvince(){
            setFetchFields("fetchFields","province");
            return this;
        }

        public QueryBuilder excludeProvince(){
            setFetchFields("excludeFields","province");
            return this;
        }

        public QueryBuilder fuzzyCity (List<String> fuzzyCity){
            this.fuzzyCity = fuzzyCity;
            return this;
        }

        public QueryBuilder fuzzyCity (String ... fuzzyCity){
            this.fuzzyCity = solveNullList(fuzzyCity);
            return this;
        }

        public QueryBuilder rightFuzzyCity (List<String> rightFuzzyCity){
            this.rightFuzzyCity = rightFuzzyCity;
            return this;
        }

        public QueryBuilder rightFuzzyCity (String ... rightFuzzyCity){
            this.rightFuzzyCity = solveNullList(rightFuzzyCity);
            return this;
        }

        public QueryBuilder city(String city){
            setCity(city);
            return this;
        }

        public QueryBuilder cityList(String ... city){
            this.cityList = solveNullList(city);
            return this;
        }

        public QueryBuilder cityList(List<String> city){
            this.cityList = city;
            return this;
        }

        public QueryBuilder fetchCity(){
            setFetchFields("fetchFields","city");
            return this;
        }

        public QueryBuilder excludeCity(){
            setFetchFields("excludeFields","city");
            return this;
        }

        public QueryBuilder fuzzyHobby (List<String> fuzzyHobby){
            this.fuzzyHobby = fuzzyHobby;
            return this;
        }

        public QueryBuilder fuzzyHobby (String ... fuzzyHobby){
            this.fuzzyHobby = solveNullList(fuzzyHobby);
            return this;
        }

        public QueryBuilder rightFuzzyHobby (List<String> rightFuzzyHobby){
            this.rightFuzzyHobby = rightFuzzyHobby;
            return this;
        }

        public QueryBuilder rightFuzzyHobby (String ... rightFuzzyHobby){
            this.rightFuzzyHobby = solveNullList(rightFuzzyHobby);
            return this;
        }

        public QueryBuilder hobby(String hobby){
            setHobby(hobby);
            return this;
        }

        public QueryBuilder hobbyList(String ... hobby){
            this.hobbyList = solveNullList(hobby);
            return this;
        }

        public QueryBuilder hobbyList(List<String> hobby){
            this.hobbyList = hobby;
            return this;
        }

        public QueryBuilder fetchHobby(){
            setFetchFields("fetchFields","hobby");
            return this;
        }

        public QueryBuilder excludeHobby(){
            setFetchFields("excludeFields","hobby");
            return this;
        }

        public QueryBuilder heightBetWeen(Integer heightSt,Integer heightEd){
            this.heightSt = heightSt;
            this.heightEd = heightEd;
            return this;
        }

        public QueryBuilder heightGreaterEqThan(Integer heightSt){
            this.heightSt = heightSt;
            return this;
        }
        public QueryBuilder heightLessEqThan(Integer heightEd){
            this.heightEd = heightEd;
            return this;
        }


        public QueryBuilder height(Integer height){
            setHeight(height);
            return this;
        }

        public QueryBuilder heightList(Integer ... height){
            this.heightList = solveNullList(height);
            return this;
        }

        public QueryBuilder heightList(List<Integer> height){
            this.heightList = height;
            return this;
        }

        public QueryBuilder fetchHeight(){
            setFetchFields("fetchFields","height");
            return this;
        }

        public QueryBuilder excludeHeight(){
            setFetchFields("excludeFields","height");
            return this;
        }

        public QueryBuilder weightBetWeen(Integer weightSt,Integer weightEd){
            this.weightSt = weightSt;
            this.weightEd = weightEd;
            return this;
        }

        public QueryBuilder weightGreaterEqThan(Integer weightSt){
            this.weightSt = weightSt;
            return this;
        }
        public QueryBuilder weightLessEqThan(Integer weightEd){
            this.weightEd = weightEd;
            return this;
        }


        public QueryBuilder weight(Integer weight){
            setWeight(weight);
            return this;
        }

        public QueryBuilder weightList(Integer ... weight){
            this.weightList = solveNullList(weight);
            return this;
        }

        public QueryBuilder weightList(List<Integer> weight){
            this.weightList = weight;
            return this;
        }

        public QueryBuilder fetchWeight(){
            setFetchFields("fetchFields","weight");
            return this;
        }

        public QueryBuilder excludeWeight(){
            setFetchFields("excludeFields","weight");
            return this;
        }

        public QueryBuilder fuzzySelfEvaluation (List<String> fuzzySelfEvaluation){
            this.fuzzySelfEvaluation = fuzzySelfEvaluation;
            return this;
        }

        public QueryBuilder fuzzySelfEvaluation (String ... fuzzySelfEvaluation){
            this.fuzzySelfEvaluation = solveNullList(fuzzySelfEvaluation);
            return this;
        }

        public QueryBuilder rightFuzzySelfEvaluation (List<String> rightFuzzySelfEvaluation){
            this.rightFuzzySelfEvaluation = rightFuzzySelfEvaluation;
            return this;
        }

        public QueryBuilder rightFuzzySelfEvaluation (String ... rightFuzzySelfEvaluation){
            this.rightFuzzySelfEvaluation = solveNullList(rightFuzzySelfEvaluation);
            return this;
        }

        public QueryBuilder selfEvaluation(String selfEvaluation){
            setSelfEvaluation(selfEvaluation);
            return this;
        }

        public QueryBuilder selfEvaluationList(String ... selfEvaluation){
            this.selfEvaluationList = solveNullList(selfEvaluation);
            return this;
        }

        public QueryBuilder selfEvaluationList(List<String> selfEvaluation){
            this.selfEvaluationList = selfEvaluation;
            return this;
        }

        public QueryBuilder fetchSelfEvaluation(){
            setFetchFields("fetchFields","selfEvaluation");
            return this;
        }

        public QueryBuilder excludeSelfEvaluation(){
            setFetchFields("excludeFields","selfEvaluation");
            return this;
        }

        public QueryBuilder fuzzyWorkArea (List<String> fuzzyWorkArea){
            this.fuzzyWorkArea = fuzzyWorkArea;
            return this;
        }

        public QueryBuilder fuzzyWorkArea (String ... fuzzyWorkArea){
            this.fuzzyWorkArea = solveNullList(fuzzyWorkArea);
            return this;
        }

        public QueryBuilder rightFuzzyWorkArea (List<String> rightFuzzyWorkArea){
            this.rightFuzzyWorkArea = rightFuzzyWorkArea;
            return this;
        }

        public QueryBuilder rightFuzzyWorkArea (String ... rightFuzzyWorkArea){
            this.rightFuzzyWorkArea = solveNullList(rightFuzzyWorkArea);
            return this;
        }

        public QueryBuilder workArea(String workArea){
            setWorkArea(workArea);
            return this;
        }

        public QueryBuilder workAreaList(String ... workArea){
            this.workAreaList = solveNullList(workArea);
            return this;
        }

        public QueryBuilder workAreaList(List<String> workArea){
            this.workAreaList = workArea;
            return this;
        }

        public QueryBuilder fetchWorkArea(){
            setFetchFields("fetchFields","workArea");
            return this;
        }

        public QueryBuilder excludeWorkArea(){
            setFetchFields("excludeFields","workArea");
            return this;
        }

        public QueryBuilder fuzzyWantSay (List<String> fuzzyWantSay){
            this.fuzzyWantSay = fuzzyWantSay;
            return this;
        }

        public QueryBuilder fuzzyWantSay (String ... fuzzyWantSay){
            this.fuzzyWantSay = solveNullList(fuzzyWantSay);
            return this;
        }

        public QueryBuilder rightFuzzyWantSay (List<String> rightFuzzyWantSay){
            this.rightFuzzyWantSay = rightFuzzyWantSay;
            return this;
        }

        public QueryBuilder rightFuzzyWantSay (String ... rightFuzzyWantSay){
            this.rightFuzzyWantSay = solveNullList(rightFuzzyWantSay);
            return this;
        }

        public QueryBuilder wantSay(String wantSay){
            setWantSay(wantSay);
            return this;
        }

        public QueryBuilder wantSayList(String ... wantSay){
            this.wantSayList = solveNullList(wantSay);
            return this;
        }

        public QueryBuilder wantSayList(List<String> wantSay){
            this.wantSayList = wantSay;
            return this;
        }

        public QueryBuilder fetchWantSay(){
            setFetchFields("fetchFields","wantSay");
            return this;
        }

        public QueryBuilder excludeWantSay(){
            setFetchFields("excludeFields","wantSay");
            return this;
        }

        public QueryBuilder fuzzyFamily (List<String> fuzzyFamily){
            this.fuzzyFamily = fuzzyFamily;
            return this;
        }

        public QueryBuilder fuzzyFamily (String ... fuzzyFamily){
            this.fuzzyFamily = solveNullList(fuzzyFamily);
            return this;
        }

        public QueryBuilder rightFuzzyFamily (List<String> rightFuzzyFamily){
            this.rightFuzzyFamily = rightFuzzyFamily;
            return this;
        }

        public QueryBuilder rightFuzzyFamily (String ... rightFuzzyFamily){
            this.rightFuzzyFamily = solveNullList(rightFuzzyFamily);
            return this;
        }

        public QueryBuilder family(String family){
            setFamily(family);
            return this;
        }

        public QueryBuilder familyList(String ... family){
            this.familyList = solveNullList(family);
            return this;
        }

        public QueryBuilder familyList(List<String> family){
            this.familyList = family;
            return this;
        }

        public QueryBuilder fetchFamily(){
            setFetchFields("fetchFields","family");
            return this;
        }

        public QueryBuilder excludeFamily(){
            setFetchFields("excludeFields","family");
            return this;
        }

        public QueryBuilder fuzzyStandFriend (List<String> fuzzyStandFriend){
            this.fuzzyStandFriend = fuzzyStandFriend;
            return this;
        }

        public QueryBuilder fuzzyStandFriend (String ... fuzzyStandFriend){
            this.fuzzyStandFriend = solveNullList(fuzzyStandFriend);
            return this;
        }

        public QueryBuilder rightFuzzyStandFriend (List<String> rightFuzzyStandFriend){
            this.rightFuzzyStandFriend = rightFuzzyStandFriend;
            return this;
        }

        public QueryBuilder rightFuzzyStandFriend (String ... rightFuzzyStandFriend){
            this.rightFuzzyStandFriend = solveNullList(rightFuzzyStandFriend);
            return this;
        }

        public QueryBuilder standFriend(String standFriend){
            setStandFriend(standFriend);
            return this;
        }

        public QueryBuilder standFriendList(String ... standFriend){
            this.standFriendList = solveNullList(standFriend);
            return this;
        }

        public QueryBuilder standFriendList(List<String> standFriend){
            this.standFriendList = standFriend;
            return this;
        }

        public QueryBuilder fetchStandFriend(){
            setFetchFields("fetchFields","standFriend");
            return this;
        }

        public QueryBuilder excludeStandFriend(){
            setFetchFields("excludeFields","standFriend");
            return this;
        }

        public QueryBuilder fuzzyPhotos (List<String> fuzzyPhotos){
            this.fuzzyPhotos = fuzzyPhotos;
            return this;
        }

        public QueryBuilder fuzzyPhotos (String ... fuzzyPhotos){
            this.fuzzyPhotos = solveNullList(fuzzyPhotos);
            return this;
        }

        public QueryBuilder rightFuzzyPhotos (List<String> rightFuzzyPhotos){
            this.rightFuzzyPhotos = rightFuzzyPhotos;
            return this;
        }

        public QueryBuilder rightFuzzyPhotos (String ... rightFuzzyPhotos){
            this.rightFuzzyPhotos = solveNullList(rightFuzzyPhotos);
            return this;
        }

        public QueryBuilder photos(String photos){
            setPhotos(photos);
            return this;
        }

        public QueryBuilder photosList(String ... photos){
            this.photosList = solveNullList(photos);
            return this;
        }

        public QueryBuilder photosList(List<String> photos){
            this.photosList = photos;
            return this;
        }

        public QueryBuilder fetchPhotos(){
            setFetchFields("fetchFields","photos");
            return this;
        }

        public QueryBuilder excludePhotos(){
            setFetchFields("excludeFields","photos");
            return this;
        }

        public QueryBuilder fuzzyDepartment (List<String> fuzzyDepartment){
            this.fuzzyDepartment = fuzzyDepartment;
            return this;
        }

        public QueryBuilder fuzzyDepartment (String ... fuzzyDepartment){
            this.fuzzyDepartment = solveNullList(fuzzyDepartment);
            return this;
        }

        public QueryBuilder rightFuzzyDepartment (List<String> rightFuzzyDepartment){
            this.rightFuzzyDepartment = rightFuzzyDepartment;
            return this;
        }

        public QueryBuilder rightFuzzyDepartment (String ... rightFuzzyDepartment){
            this.rightFuzzyDepartment = solveNullList(rightFuzzyDepartment);
            return this;
        }

        public QueryBuilder department(String department){
            setDepartment(department);
            return this;
        }

        public QueryBuilder departmentList(String ... department){
            this.departmentList = solveNullList(department);
            return this;
        }

        public QueryBuilder departmentList(List<String> department){
            this.departmentList = department;
            return this;
        }

        public QueryBuilder fetchDepartment(){
            setFetchFields("fetchFields","department");
            return this;
        }

        public QueryBuilder excludeDepartment(){
            setFetchFields("excludeFields","department");
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

        public QueryBuilder fuzzyRejectReason (List<String> fuzzyRejectReason){
            this.fuzzyRejectReason = fuzzyRejectReason;
            return this;
        }

        public QueryBuilder fuzzyRejectReason (String ... fuzzyRejectReason){
            this.fuzzyRejectReason = solveNullList(fuzzyRejectReason);
            return this;
        }

        public QueryBuilder rightFuzzyRejectReason (List<String> rightFuzzyRejectReason){
            this.rightFuzzyRejectReason = rightFuzzyRejectReason;
            return this;
        }

        public QueryBuilder rightFuzzyRejectReason (String ... rightFuzzyRejectReason){
            this.rightFuzzyRejectReason = solveNullList(rightFuzzyRejectReason);
            return this;
        }

        public QueryBuilder rejectReason(String rejectReason){
            setRejectReason(rejectReason);
            return this;
        }

        public QueryBuilder rejectReasonList(String ... rejectReason){
            this.rejectReasonList = solveNullList(rejectReason);
            return this;
        }

        public QueryBuilder rejectReasonList(List<String> rejectReason){
            this.rejectReasonList = rejectReason;
            return this;
        }

        public QueryBuilder fetchRejectReason(){
            setFetchFields("fetchFields","rejectReason");
            return this;
        }

        public QueryBuilder excludeRejectReason(){
            setFetchFields("excludeFields","rejectReason");
            return this;
        }

        public QueryBuilder fuzzyDongdong (List<String> fuzzyDongdong){
            this.fuzzyDongdong = fuzzyDongdong;
            return this;
        }

        public QueryBuilder fuzzyDongdong (String ... fuzzyDongdong){
            this.fuzzyDongdong = solveNullList(fuzzyDongdong);
            return this;
        }

        public QueryBuilder rightFuzzyDongdong (List<String> rightFuzzyDongdong){
            this.rightFuzzyDongdong = rightFuzzyDongdong;
            return this;
        }

        public QueryBuilder rightFuzzyDongdong (String ... rightFuzzyDongdong){
            this.rightFuzzyDongdong = solveNullList(rightFuzzyDongdong);
            return this;
        }

        public QueryBuilder dongdong(String dongdong){
            setDongdong(dongdong);
            return this;
        }

        public QueryBuilder dongdongList(String ... dongdong){
            this.dongdongList = solveNullList(dongdong);
            return this;
        }

        public QueryBuilder dongdongList(List<String> dongdong){
            this.dongdongList = dongdong;
            return this;
        }

        public QueryBuilder fetchDongdong(){
            setFetchFields("fetchFields","dongdong");
            return this;
        }

        public QueryBuilder excludeDongdong(){
            setFetchFields("excludeFields","dongdong");
            return this;
        }

        public QueryBuilder fuzzyWxNumber (List<String> fuzzyWxNumber){
            this.fuzzyWxNumber = fuzzyWxNumber;
            return this;
        }

        public QueryBuilder fuzzyWxNumber (String ... fuzzyWxNumber){
            this.fuzzyWxNumber = solveNullList(fuzzyWxNumber);
            return this;
        }

        public QueryBuilder rightFuzzyWxNumber (List<String> rightFuzzyWxNumber){
            this.rightFuzzyWxNumber = rightFuzzyWxNumber;
            return this;
        }

        public QueryBuilder rightFuzzyWxNumber (String ... rightFuzzyWxNumber){
            this.rightFuzzyWxNumber = solveNullList(rightFuzzyWxNumber);
            return this;
        }

        public QueryBuilder wxNumber(String wxNumber){
            setWxNumber(wxNumber);
            return this;
        }

        public QueryBuilder wxNumberList(String ... wxNumber){
            this.wxNumberList = solveNullList(wxNumber);
            return this;
        }

        public QueryBuilder wxNumberList(List<String> wxNumber){
            this.wxNumberList = wxNumber;
            return this;
        }

        public QueryBuilder fetchWxNumber(){
            setFetchFields("fetchFields","wxNumber");
            return this;
        }

        public QueryBuilder excludeWxNumber(){
            setFetchFields("excludeFields","wxNumber");
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

        public QueryBuilder fuzzyDoingTags (List<String> fuzzyDoingTags){
            this.fuzzyDoingTags = fuzzyDoingTags;
            return this;
        }

        public QueryBuilder fuzzyDoingTags (String ... fuzzyDoingTags){
            this.fuzzyDoingTags = solveNullList(fuzzyDoingTags);
            return this;
        }

        public QueryBuilder rightFuzzyDoingTags (List<String> rightFuzzyDoingTags){
            this.rightFuzzyDoingTags = rightFuzzyDoingTags;
            return this;
        }

        public QueryBuilder rightFuzzyDoingTags (String ... rightFuzzyDoingTags){
            this.rightFuzzyDoingTags = solveNullList(rightFuzzyDoingTags);
            return this;
        }

        public QueryBuilder doingTags(String doingTags){
            setDoingTags(doingTags);
            return this;
        }

        public QueryBuilder doingTagsList(String ... doingTags){
            this.doingTagsList = solveNullList(doingTags);
            return this;
        }

        public QueryBuilder doingTagsList(List<String> doingTags){
            this.doingTagsList = doingTags;
            return this;
        }

        public QueryBuilder fetchDoingTags(){
            setFetchFields("fetchFields","doingTags");
            return this;
        }

        public QueryBuilder excludeDoingTags(){
            setFetchFields("excludeFields","doingTags");
            return this;
        }

        public QueryBuilder fuzzyPlanTags (List<String> fuzzyPlanTags){
            this.fuzzyPlanTags = fuzzyPlanTags;
            return this;
        }

        public QueryBuilder fuzzyPlanTags (String ... fuzzyPlanTags){
            this.fuzzyPlanTags = solveNullList(fuzzyPlanTags);
            return this;
        }

        public QueryBuilder rightFuzzyPlanTags (List<String> rightFuzzyPlanTags){
            this.rightFuzzyPlanTags = rightFuzzyPlanTags;
            return this;
        }

        public QueryBuilder rightFuzzyPlanTags (String ... rightFuzzyPlanTags){
            this.rightFuzzyPlanTags = solveNullList(rightFuzzyPlanTags);
            return this;
        }

        public QueryBuilder planTags(String planTags){
            setPlanTags(planTags);
            return this;
        }

        public QueryBuilder planTagsList(String ... planTags){
            this.planTagsList = solveNullList(planTags);
            return this;
        }

        public QueryBuilder planTagsList(List<String> planTags){
            this.planTagsList = planTags;
            return this;
        }

        public QueryBuilder fetchPlanTags(){
            setFetchFields("fetchFields","planTags");
            return this;
        }

        public QueryBuilder excludePlanTags(){
            setFetchFields("excludeFields","planTags");
            return this;
        }

        public QueryBuilder fuzzyActivityTags (List<String> fuzzyActivityTags){
            this.fuzzyActivityTags = fuzzyActivityTags;
            return this;
        }

        public QueryBuilder fuzzyActivityTags (String ... fuzzyActivityTags){
            this.fuzzyActivityTags = solveNullList(fuzzyActivityTags);
            return this;
        }

        public QueryBuilder rightFuzzyActivityTags (List<String> rightFuzzyActivityTags){
            this.rightFuzzyActivityTags = rightFuzzyActivityTags;
            return this;
        }

        public QueryBuilder rightFuzzyActivityTags (String ... rightFuzzyActivityTags){
            this.rightFuzzyActivityTags = solveNullList(rightFuzzyActivityTags);
            return this;
        }

        public QueryBuilder activityTags(String activityTags){
            setActivityTags(activityTags);
            return this;
        }

        public QueryBuilder activityTagsList(String ... activityTags){
            this.activityTagsList = solveNullList(activityTags);
            return this;
        }

        public QueryBuilder activityTagsList(List<String> activityTags){
            this.activityTagsList = activityTags;
            return this;
        }

        public QueryBuilder fetchActivityTags(){
            setFetchFields("fetchFields","activityTags");
            return this;
        }

        public QueryBuilder excludeActivityTags(){
            setFetchFields("excludeFields","activityTags");
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

        private List<String> openIdList;

        public List<String> getOpenIdList(){return this.openIdList;}


        private List<String> fuzzyOpenId;

        public List<String> getFuzzyOpenId(){return this.fuzzyOpenId;}

        private List<String> rightFuzzyOpenId;

        public List<String> getRightFuzzyOpenId(){return this.rightFuzzyOpenId;}
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

        private List<Integer> constellationList;

        public List<Integer> getConstellationList(){return this.constellationList;}

        private Integer constellationSt;

        private Integer constellationEd;

        public Integer getConstellationSt(){return this.constellationSt;}

        public Integer getConstellationEd(){return this.constellationEd;}

        private List<java.time.LocalDate> birthdayList;

        public List<java.time.LocalDate> getBirthdayList(){return this.birthdayList;}

        private java.time.LocalDate birthdaySt;

        private java.time.LocalDate birthdayEd;

        public java.time.LocalDate getBirthdaySt(){return this.birthdaySt;}

        public java.time.LocalDate getBirthdayEd(){return this.birthdayEd;}

        private List<Integer> educationList;

        public List<Integer> getEducationList(){return this.educationList;}

        private Integer educationSt;

        private Integer educationEd;

        public Integer getEducationSt(){return this.educationSt;}

        public Integer getEducationEd(){return this.educationEd;}

        private List<Integer> sexList;

        public List<Integer> getSexList(){return this.sexList;}

        private Integer sexSt;

        private Integer sexEd;

        public Integer getSexSt(){return this.sexSt;}

        public Integer getSexEd(){return this.sexEd;}

        private List<String> provinceList;

        public List<String> getProvinceList(){return this.provinceList;}


        private List<String> fuzzyProvince;

        public List<String> getFuzzyProvince(){return this.fuzzyProvince;}

        private List<String> rightFuzzyProvince;

        public List<String> getRightFuzzyProvince(){return this.rightFuzzyProvince;}
        private List<String> cityList;

        public List<String> getCityList(){return this.cityList;}


        private List<String> fuzzyCity;

        public List<String> getFuzzyCity(){return this.fuzzyCity;}

        private List<String> rightFuzzyCity;

        public List<String> getRightFuzzyCity(){return this.rightFuzzyCity;}
        private List<String> hobbyList;

        public List<String> getHobbyList(){return this.hobbyList;}


        private List<String> fuzzyHobby;

        public List<String> getFuzzyHobby(){return this.fuzzyHobby;}

        private List<String> rightFuzzyHobby;

        public List<String> getRightFuzzyHobby(){return this.rightFuzzyHobby;}
        private List<Integer> heightList;

        public List<Integer> getHeightList(){return this.heightList;}

        private Integer heightSt;

        private Integer heightEd;

        public Integer getHeightSt(){return this.heightSt;}

        public Integer getHeightEd(){return this.heightEd;}

        private List<Integer> weightList;

        public List<Integer> getWeightList(){return this.weightList;}

        private Integer weightSt;

        private Integer weightEd;

        public Integer getWeightSt(){return this.weightSt;}

        public Integer getWeightEd(){return this.weightEd;}

        private List<String> selfEvaluationList;

        public List<String> getSelfEvaluationList(){return this.selfEvaluationList;}


        private List<String> fuzzySelfEvaluation;

        public List<String> getFuzzySelfEvaluation(){return this.fuzzySelfEvaluation;}

        private List<String> rightFuzzySelfEvaluation;

        public List<String> getRightFuzzySelfEvaluation(){return this.rightFuzzySelfEvaluation;}
        private List<String> workAreaList;

        public List<String> getWorkAreaList(){return this.workAreaList;}


        private List<String> fuzzyWorkArea;

        public List<String> getFuzzyWorkArea(){return this.fuzzyWorkArea;}

        private List<String> rightFuzzyWorkArea;

        public List<String> getRightFuzzyWorkArea(){return this.rightFuzzyWorkArea;}
        private List<String> wantSayList;

        public List<String> getWantSayList(){return this.wantSayList;}


        private List<String> fuzzyWantSay;

        public List<String> getFuzzyWantSay(){return this.fuzzyWantSay;}

        private List<String> rightFuzzyWantSay;

        public List<String> getRightFuzzyWantSay(){return this.rightFuzzyWantSay;}
        private List<String> familyList;

        public List<String> getFamilyList(){return this.familyList;}


        private List<String> fuzzyFamily;

        public List<String> getFuzzyFamily(){return this.fuzzyFamily;}

        private List<String> rightFuzzyFamily;

        public List<String> getRightFuzzyFamily(){return this.rightFuzzyFamily;}
        private List<String> standFriendList;

        public List<String> getStandFriendList(){return this.standFriendList;}


        private List<String> fuzzyStandFriend;

        public List<String> getFuzzyStandFriend(){return this.fuzzyStandFriend;}

        private List<String> rightFuzzyStandFriend;

        public List<String> getRightFuzzyStandFriend(){return this.rightFuzzyStandFriend;}
        private List<String> photosList;

        public List<String> getPhotosList(){return this.photosList;}


        private List<String> fuzzyPhotos;

        public List<String> getFuzzyPhotos(){return this.fuzzyPhotos;}

        private List<String> rightFuzzyPhotos;

        public List<String> getRightFuzzyPhotos(){return this.rightFuzzyPhotos;}
        private List<String> departmentList;

        public List<String> getDepartmentList(){return this.departmentList;}


        private List<String> fuzzyDepartment;

        public List<String> getFuzzyDepartment(){return this.fuzzyDepartment;}

        private List<String> rightFuzzyDepartment;

        public List<String> getRightFuzzyDepartment(){return this.rightFuzzyDepartment;}
        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> rejectReasonList;

        public List<String> getRejectReasonList(){return this.rejectReasonList;}


        private List<String> fuzzyRejectReason;

        public List<String> getFuzzyRejectReason(){return this.fuzzyRejectReason;}

        private List<String> rightFuzzyRejectReason;

        public List<String> getRightFuzzyRejectReason(){return this.rightFuzzyRejectReason;}
        private List<String> dongdongList;

        public List<String> getDongdongList(){return this.dongdongList;}


        private List<String> fuzzyDongdong;

        public List<String> getFuzzyDongdong(){return this.fuzzyDongdong;}

        private List<String> rightFuzzyDongdong;

        public List<String> getRightFuzzyDongdong(){return this.rightFuzzyDongdong;}
        private List<String> wxNumberList;

        public List<String> getWxNumberList(){return this.wxNumberList;}


        private List<String> fuzzyWxNumber;

        public List<String> getFuzzyWxNumber(){return this.fuzzyWxNumber;}

        private List<String> rightFuzzyWxNumber;

        public List<String> getRightFuzzyWxNumber(){return this.rightFuzzyWxNumber;}
        private List<java.time.LocalDateTime> createList;

        public List<java.time.LocalDateTime> getCreateList(){return this.createList;}

        private java.time.LocalDateTime createSt;

        private java.time.LocalDateTime createEd;

        public java.time.LocalDateTime getCreateSt(){return this.createSt;}

        public java.time.LocalDateTime getCreateEd(){return this.createEd;}

        private List<java.time.LocalDateTime> modifiedList;

        public List<java.time.LocalDateTime> getModifiedList(){return this.modifiedList;}

        private java.time.LocalDateTime modifiedSt;

        private java.time.LocalDateTime modifiedEd;

        public java.time.LocalDateTime getModifiedSt(){return this.modifiedSt;}

        public java.time.LocalDateTime getModifiedEd(){return this.modifiedEd;}

        private List<String> extList;

        public List<String> getExtList(){return this.extList;}


        private List<String> fuzzyExt;

        public List<String> getFuzzyExt(){return this.fuzzyExt;}

        private List<String> rightFuzzyExt;

        public List<String> getRightFuzzyExt(){return this.rightFuzzyExt;}
        private List<String> doingTagsList;

        public List<String> getDoingTagsList(){return this.doingTagsList;}


        private List<String> fuzzyDoingTags;

        public List<String> getFuzzyDoingTags(){return this.fuzzyDoingTags;}

        private List<String> rightFuzzyDoingTags;

        public List<String> getRightFuzzyDoingTags(){return this.rightFuzzyDoingTags;}
        private List<String> planTagsList;

        public List<String> getPlanTagsList(){return this.planTagsList;}


        private List<String> fuzzyPlanTags;

        public List<String> getFuzzyPlanTags(){return this.fuzzyPlanTags;}

        private List<String> rightFuzzyPlanTags;

        public List<String> getRightFuzzyPlanTags(){return this.rightFuzzyPlanTags;}
        private List<String> activityTagsList;

        public List<String> getActivityTagsList(){return this.activityTagsList;}


        private List<String> fuzzyActivityTags;

        public List<String> getFuzzyActivityTags(){return this.fuzzyActivityTags;}

        private List<String> rightFuzzyActivityTags;

        public List<String> getRightFuzzyActivityTags(){return this.rightFuzzyActivityTags;}

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

        public ConditionBuilder constellationBetWeen(Integer constellationSt,Integer constellationEd){
            this.constellationSt = constellationSt;
            this.constellationEd = constellationEd;
            return this;
        }

        public ConditionBuilder constellationGreaterEqThan(Integer constellationSt){
            this.constellationSt = constellationSt;
            return this;
        }
        public ConditionBuilder constellationLessEqThan(Integer constellationEd){
            this.constellationEd = constellationEd;
            return this;
        }


        public ConditionBuilder constellationList(Integer ... constellation){
            this.constellationList = solveNullList(constellation);
            return this;
        }

        public ConditionBuilder constellationList(List<Integer> constellation){
            this.constellationList = constellation;
            return this;
        }

        public ConditionBuilder birthdayBetWeen(java.time.LocalDate birthdaySt,java.time.LocalDate birthdayEd){
            this.birthdaySt = birthdaySt;
            this.birthdayEd = birthdayEd;
            return this;
        }

        public ConditionBuilder birthdayGreaterEqThan(java.time.LocalDate birthdaySt){
            this.birthdaySt = birthdaySt;
            return this;
        }
        public ConditionBuilder birthdayLessEqThan(java.time.LocalDate birthdayEd){
            this.birthdayEd = birthdayEd;
            return this;
        }


        public ConditionBuilder birthdayList(java.time.LocalDate ... birthday){
            this.birthdayList = solveNullList(birthday);
            return this;
        }

        public ConditionBuilder birthdayList(List<java.time.LocalDate> birthday){
            this.birthdayList = birthday;
            return this;
        }

        public ConditionBuilder educationBetWeen(Integer educationSt,Integer educationEd){
            this.educationSt = educationSt;
            this.educationEd = educationEd;
            return this;
        }

        public ConditionBuilder educationGreaterEqThan(Integer educationSt){
            this.educationSt = educationSt;
            return this;
        }
        public ConditionBuilder educationLessEqThan(Integer educationEd){
            this.educationEd = educationEd;
            return this;
        }


        public ConditionBuilder educationList(Integer ... education){
            this.educationList = solveNullList(education);
            return this;
        }

        public ConditionBuilder educationList(List<Integer> education){
            this.educationList = education;
            return this;
        }

        public ConditionBuilder sexBetWeen(Integer sexSt,Integer sexEd){
            this.sexSt = sexSt;
            this.sexEd = sexEd;
            return this;
        }

        public ConditionBuilder sexGreaterEqThan(Integer sexSt){
            this.sexSt = sexSt;
            return this;
        }
        public ConditionBuilder sexLessEqThan(Integer sexEd){
            this.sexEd = sexEd;
            return this;
        }


        public ConditionBuilder sexList(Integer ... sex){
            this.sexList = solveNullList(sex);
            return this;
        }

        public ConditionBuilder sexList(List<Integer> sex){
            this.sexList = sex;
            return this;
        }

        public ConditionBuilder fuzzyProvince (List<String> fuzzyProvince){
            this.fuzzyProvince = fuzzyProvince;
            return this;
        }

        public ConditionBuilder fuzzyProvince (String ... fuzzyProvince){
            this.fuzzyProvince = solveNullList(fuzzyProvince);
            return this;
        }

        public ConditionBuilder rightFuzzyProvince (List<String> rightFuzzyProvince){
            this.rightFuzzyProvince = rightFuzzyProvince;
            return this;
        }

        public ConditionBuilder rightFuzzyProvince (String ... rightFuzzyProvince){
            this.rightFuzzyProvince = solveNullList(rightFuzzyProvince);
            return this;
        }

        public ConditionBuilder provinceList(String ... province){
            this.provinceList = solveNullList(province);
            return this;
        }

        public ConditionBuilder provinceList(List<String> province){
            this.provinceList = province;
            return this;
        }

        public ConditionBuilder fuzzyCity (List<String> fuzzyCity){
            this.fuzzyCity = fuzzyCity;
            return this;
        }

        public ConditionBuilder fuzzyCity (String ... fuzzyCity){
            this.fuzzyCity = solveNullList(fuzzyCity);
            return this;
        }

        public ConditionBuilder rightFuzzyCity (List<String> rightFuzzyCity){
            this.rightFuzzyCity = rightFuzzyCity;
            return this;
        }

        public ConditionBuilder rightFuzzyCity (String ... rightFuzzyCity){
            this.rightFuzzyCity = solveNullList(rightFuzzyCity);
            return this;
        }

        public ConditionBuilder cityList(String ... city){
            this.cityList = solveNullList(city);
            return this;
        }

        public ConditionBuilder cityList(List<String> city){
            this.cityList = city;
            return this;
        }

        public ConditionBuilder fuzzyHobby (List<String> fuzzyHobby){
            this.fuzzyHobby = fuzzyHobby;
            return this;
        }

        public ConditionBuilder fuzzyHobby (String ... fuzzyHobby){
            this.fuzzyHobby = solveNullList(fuzzyHobby);
            return this;
        }

        public ConditionBuilder rightFuzzyHobby (List<String> rightFuzzyHobby){
            this.rightFuzzyHobby = rightFuzzyHobby;
            return this;
        }

        public ConditionBuilder rightFuzzyHobby (String ... rightFuzzyHobby){
            this.rightFuzzyHobby = solveNullList(rightFuzzyHobby);
            return this;
        }

        public ConditionBuilder hobbyList(String ... hobby){
            this.hobbyList = solveNullList(hobby);
            return this;
        }

        public ConditionBuilder hobbyList(List<String> hobby){
            this.hobbyList = hobby;
            return this;
        }

        public ConditionBuilder heightBetWeen(Integer heightSt,Integer heightEd){
            this.heightSt = heightSt;
            this.heightEd = heightEd;
            return this;
        }

        public ConditionBuilder heightGreaterEqThan(Integer heightSt){
            this.heightSt = heightSt;
            return this;
        }
        public ConditionBuilder heightLessEqThan(Integer heightEd){
            this.heightEd = heightEd;
            return this;
        }


        public ConditionBuilder heightList(Integer ... height){
            this.heightList = solveNullList(height);
            return this;
        }

        public ConditionBuilder heightList(List<Integer> height){
            this.heightList = height;
            return this;
        }

        public ConditionBuilder weightBetWeen(Integer weightSt,Integer weightEd){
            this.weightSt = weightSt;
            this.weightEd = weightEd;
            return this;
        }

        public ConditionBuilder weightGreaterEqThan(Integer weightSt){
            this.weightSt = weightSt;
            return this;
        }
        public ConditionBuilder weightLessEqThan(Integer weightEd){
            this.weightEd = weightEd;
            return this;
        }


        public ConditionBuilder weightList(Integer ... weight){
            this.weightList = solveNullList(weight);
            return this;
        }

        public ConditionBuilder weightList(List<Integer> weight){
            this.weightList = weight;
            return this;
        }

        public ConditionBuilder fuzzySelfEvaluation (List<String> fuzzySelfEvaluation){
            this.fuzzySelfEvaluation = fuzzySelfEvaluation;
            return this;
        }

        public ConditionBuilder fuzzySelfEvaluation (String ... fuzzySelfEvaluation){
            this.fuzzySelfEvaluation = solveNullList(fuzzySelfEvaluation);
            return this;
        }

        public ConditionBuilder rightFuzzySelfEvaluation (List<String> rightFuzzySelfEvaluation){
            this.rightFuzzySelfEvaluation = rightFuzzySelfEvaluation;
            return this;
        }

        public ConditionBuilder rightFuzzySelfEvaluation (String ... rightFuzzySelfEvaluation){
            this.rightFuzzySelfEvaluation = solveNullList(rightFuzzySelfEvaluation);
            return this;
        }

        public ConditionBuilder selfEvaluationList(String ... selfEvaluation){
            this.selfEvaluationList = solveNullList(selfEvaluation);
            return this;
        }

        public ConditionBuilder selfEvaluationList(List<String> selfEvaluation){
            this.selfEvaluationList = selfEvaluation;
            return this;
        }

        public ConditionBuilder fuzzyWorkArea (List<String> fuzzyWorkArea){
            this.fuzzyWorkArea = fuzzyWorkArea;
            return this;
        }

        public ConditionBuilder fuzzyWorkArea (String ... fuzzyWorkArea){
            this.fuzzyWorkArea = solveNullList(fuzzyWorkArea);
            return this;
        }

        public ConditionBuilder rightFuzzyWorkArea (List<String> rightFuzzyWorkArea){
            this.rightFuzzyWorkArea = rightFuzzyWorkArea;
            return this;
        }

        public ConditionBuilder rightFuzzyWorkArea (String ... rightFuzzyWorkArea){
            this.rightFuzzyWorkArea = solveNullList(rightFuzzyWorkArea);
            return this;
        }

        public ConditionBuilder workAreaList(String ... workArea){
            this.workAreaList = solveNullList(workArea);
            return this;
        }

        public ConditionBuilder workAreaList(List<String> workArea){
            this.workAreaList = workArea;
            return this;
        }

        public ConditionBuilder fuzzyWantSay (List<String> fuzzyWantSay){
            this.fuzzyWantSay = fuzzyWantSay;
            return this;
        }

        public ConditionBuilder fuzzyWantSay (String ... fuzzyWantSay){
            this.fuzzyWantSay = solveNullList(fuzzyWantSay);
            return this;
        }

        public ConditionBuilder rightFuzzyWantSay (List<String> rightFuzzyWantSay){
            this.rightFuzzyWantSay = rightFuzzyWantSay;
            return this;
        }

        public ConditionBuilder rightFuzzyWantSay (String ... rightFuzzyWantSay){
            this.rightFuzzyWantSay = solveNullList(rightFuzzyWantSay);
            return this;
        }

        public ConditionBuilder wantSayList(String ... wantSay){
            this.wantSayList = solveNullList(wantSay);
            return this;
        }

        public ConditionBuilder wantSayList(List<String> wantSay){
            this.wantSayList = wantSay;
            return this;
        }

        public ConditionBuilder fuzzyFamily (List<String> fuzzyFamily){
            this.fuzzyFamily = fuzzyFamily;
            return this;
        }

        public ConditionBuilder fuzzyFamily (String ... fuzzyFamily){
            this.fuzzyFamily = solveNullList(fuzzyFamily);
            return this;
        }

        public ConditionBuilder rightFuzzyFamily (List<String> rightFuzzyFamily){
            this.rightFuzzyFamily = rightFuzzyFamily;
            return this;
        }

        public ConditionBuilder rightFuzzyFamily (String ... rightFuzzyFamily){
            this.rightFuzzyFamily = solveNullList(rightFuzzyFamily);
            return this;
        }

        public ConditionBuilder familyList(String ... family){
            this.familyList = solveNullList(family);
            return this;
        }

        public ConditionBuilder familyList(List<String> family){
            this.familyList = family;
            return this;
        }

        public ConditionBuilder fuzzyStandFriend (List<String> fuzzyStandFriend){
            this.fuzzyStandFriend = fuzzyStandFriend;
            return this;
        }

        public ConditionBuilder fuzzyStandFriend (String ... fuzzyStandFriend){
            this.fuzzyStandFriend = solveNullList(fuzzyStandFriend);
            return this;
        }

        public ConditionBuilder rightFuzzyStandFriend (List<String> rightFuzzyStandFriend){
            this.rightFuzzyStandFriend = rightFuzzyStandFriend;
            return this;
        }

        public ConditionBuilder rightFuzzyStandFriend (String ... rightFuzzyStandFriend){
            this.rightFuzzyStandFriend = solveNullList(rightFuzzyStandFriend);
            return this;
        }

        public ConditionBuilder standFriendList(String ... standFriend){
            this.standFriendList = solveNullList(standFriend);
            return this;
        }

        public ConditionBuilder standFriendList(List<String> standFriend){
            this.standFriendList = standFriend;
            return this;
        }

        public ConditionBuilder fuzzyPhotos (List<String> fuzzyPhotos){
            this.fuzzyPhotos = fuzzyPhotos;
            return this;
        }

        public ConditionBuilder fuzzyPhotos (String ... fuzzyPhotos){
            this.fuzzyPhotos = solveNullList(fuzzyPhotos);
            return this;
        }

        public ConditionBuilder rightFuzzyPhotos (List<String> rightFuzzyPhotos){
            this.rightFuzzyPhotos = rightFuzzyPhotos;
            return this;
        }

        public ConditionBuilder rightFuzzyPhotos (String ... rightFuzzyPhotos){
            this.rightFuzzyPhotos = solveNullList(rightFuzzyPhotos);
            return this;
        }

        public ConditionBuilder photosList(String ... photos){
            this.photosList = solveNullList(photos);
            return this;
        }

        public ConditionBuilder photosList(List<String> photos){
            this.photosList = photos;
            return this;
        }

        public ConditionBuilder fuzzyDepartment (List<String> fuzzyDepartment){
            this.fuzzyDepartment = fuzzyDepartment;
            return this;
        }

        public ConditionBuilder fuzzyDepartment (String ... fuzzyDepartment){
            this.fuzzyDepartment = solveNullList(fuzzyDepartment);
            return this;
        }

        public ConditionBuilder rightFuzzyDepartment (List<String> rightFuzzyDepartment){
            this.rightFuzzyDepartment = rightFuzzyDepartment;
            return this;
        }

        public ConditionBuilder rightFuzzyDepartment (String ... rightFuzzyDepartment){
            this.rightFuzzyDepartment = solveNullList(rightFuzzyDepartment);
            return this;
        }

        public ConditionBuilder departmentList(String ... department){
            this.departmentList = solveNullList(department);
            return this;
        }

        public ConditionBuilder departmentList(List<String> department){
            this.departmentList = department;
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

        public ConditionBuilder fuzzyRejectReason (List<String> fuzzyRejectReason){
            this.fuzzyRejectReason = fuzzyRejectReason;
            return this;
        }

        public ConditionBuilder fuzzyRejectReason (String ... fuzzyRejectReason){
            this.fuzzyRejectReason = solveNullList(fuzzyRejectReason);
            return this;
        }

        public ConditionBuilder rightFuzzyRejectReason (List<String> rightFuzzyRejectReason){
            this.rightFuzzyRejectReason = rightFuzzyRejectReason;
            return this;
        }

        public ConditionBuilder rightFuzzyRejectReason (String ... rightFuzzyRejectReason){
            this.rightFuzzyRejectReason = solveNullList(rightFuzzyRejectReason);
            return this;
        }

        public ConditionBuilder rejectReasonList(String ... rejectReason){
            this.rejectReasonList = solveNullList(rejectReason);
            return this;
        }

        public ConditionBuilder rejectReasonList(List<String> rejectReason){
            this.rejectReasonList = rejectReason;
            return this;
        }

        public ConditionBuilder fuzzyDongdong (List<String> fuzzyDongdong){
            this.fuzzyDongdong = fuzzyDongdong;
            return this;
        }

        public ConditionBuilder fuzzyDongdong (String ... fuzzyDongdong){
            this.fuzzyDongdong = solveNullList(fuzzyDongdong);
            return this;
        }

        public ConditionBuilder rightFuzzyDongdong (List<String> rightFuzzyDongdong){
            this.rightFuzzyDongdong = rightFuzzyDongdong;
            return this;
        }

        public ConditionBuilder rightFuzzyDongdong (String ... rightFuzzyDongdong){
            this.rightFuzzyDongdong = solveNullList(rightFuzzyDongdong);
            return this;
        }

        public ConditionBuilder dongdongList(String ... dongdong){
            this.dongdongList = solveNullList(dongdong);
            return this;
        }

        public ConditionBuilder dongdongList(List<String> dongdong){
            this.dongdongList = dongdong;
            return this;
        }

        public ConditionBuilder fuzzyWxNumber (List<String> fuzzyWxNumber){
            this.fuzzyWxNumber = fuzzyWxNumber;
            return this;
        }

        public ConditionBuilder fuzzyWxNumber (String ... fuzzyWxNumber){
            this.fuzzyWxNumber = solveNullList(fuzzyWxNumber);
            return this;
        }

        public ConditionBuilder rightFuzzyWxNumber (List<String> rightFuzzyWxNumber){
            this.rightFuzzyWxNumber = rightFuzzyWxNumber;
            return this;
        }

        public ConditionBuilder rightFuzzyWxNumber (String ... rightFuzzyWxNumber){
            this.rightFuzzyWxNumber = solveNullList(rightFuzzyWxNumber);
            return this;
        }

        public ConditionBuilder wxNumberList(String ... wxNumber){
            this.wxNumberList = solveNullList(wxNumber);
            return this;
        }

        public ConditionBuilder wxNumberList(List<String> wxNumber){
            this.wxNumberList = wxNumber;
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

        public ConditionBuilder fuzzyDoingTags (List<String> fuzzyDoingTags){
            this.fuzzyDoingTags = fuzzyDoingTags;
            return this;
        }

        public ConditionBuilder fuzzyDoingTags (String ... fuzzyDoingTags){
            this.fuzzyDoingTags = solveNullList(fuzzyDoingTags);
            return this;
        }

        public ConditionBuilder rightFuzzyDoingTags (List<String> rightFuzzyDoingTags){
            this.rightFuzzyDoingTags = rightFuzzyDoingTags;
            return this;
        }

        public ConditionBuilder rightFuzzyDoingTags (String ... rightFuzzyDoingTags){
            this.rightFuzzyDoingTags = solveNullList(rightFuzzyDoingTags);
            return this;
        }

        public ConditionBuilder doingTagsList(String ... doingTags){
            this.doingTagsList = solveNullList(doingTags);
            return this;
        }

        public ConditionBuilder doingTagsList(List<String> doingTags){
            this.doingTagsList = doingTags;
            return this;
        }

        public ConditionBuilder fuzzyPlanTags (List<String> fuzzyPlanTags){
            this.fuzzyPlanTags = fuzzyPlanTags;
            return this;
        }

        public ConditionBuilder fuzzyPlanTags (String ... fuzzyPlanTags){
            this.fuzzyPlanTags = solveNullList(fuzzyPlanTags);
            return this;
        }

        public ConditionBuilder rightFuzzyPlanTags (List<String> rightFuzzyPlanTags){
            this.rightFuzzyPlanTags = rightFuzzyPlanTags;
            return this;
        }

        public ConditionBuilder rightFuzzyPlanTags (String ... rightFuzzyPlanTags){
            this.rightFuzzyPlanTags = solveNullList(rightFuzzyPlanTags);
            return this;
        }

        public ConditionBuilder planTagsList(String ... planTags){
            this.planTagsList = solveNullList(planTags);
            return this;
        }

        public ConditionBuilder planTagsList(List<String> planTags){
            this.planTagsList = planTags;
            return this;
        }

        public ConditionBuilder fuzzyActivityTags (List<String> fuzzyActivityTags){
            this.fuzzyActivityTags = fuzzyActivityTags;
            return this;
        }

        public ConditionBuilder fuzzyActivityTags (String ... fuzzyActivityTags){
            this.fuzzyActivityTags = solveNullList(fuzzyActivityTags);
            return this;
        }

        public ConditionBuilder rightFuzzyActivityTags (List<String> rightFuzzyActivityTags){
            this.rightFuzzyActivityTags = rightFuzzyActivityTags;
            return this;
        }

        public ConditionBuilder rightFuzzyActivityTags (String ... rightFuzzyActivityTags){
            this.rightFuzzyActivityTags = solveNullList(rightFuzzyActivityTags);
            return this;
        }

        public ConditionBuilder activityTagsList(String ... activityTags){
            this.activityTagsList = solveNullList(activityTags);
            return this;
        }

        public ConditionBuilder activityTagsList(List<String> activityTags){
            this.activityTagsList = activityTags;
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
        public Builder openId(String openId){
            this.obj.setOpenId(openId);
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
        public Builder constellation(Integer constellation){
            this.obj.setConstellation(constellation);
            return this;
        }
        public Builder birthday(java.time.LocalDate birthday){
            this.obj.setBirthday(birthday);
            return this;
        }
        public Builder education(Integer education){
            this.obj.setEducation(education);
            return this;
        }
        public Builder sex(Integer sex){
            this.obj.setSex(sex);
            return this;
        }
        public Builder province(String province){
            this.obj.setProvince(province);
            return this;
        }
        public Builder city(String city){
            this.obj.setCity(city);
            return this;
        }
        public Builder hobby(String hobby){
            this.obj.setHobby(hobby);
            return this;
        }
        public Builder height(Integer height){
            this.obj.setHeight(height);
            return this;
        }
        public Builder weight(Integer weight){
            this.obj.setWeight(weight);
            return this;
        }
        public Builder selfEvaluation(String selfEvaluation){
            this.obj.setSelfEvaluation(selfEvaluation);
            return this;
        }
        public Builder workArea(String workArea){
            this.obj.setWorkArea(workArea);
            return this;
        }
        public Builder wantSay(String wantSay){
            this.obj.setWantSay(wantSay);
            return this;
        }
        public Builder family(String family){
            this.obj.setFamily(family);
            return this;
        }
        public Builder standFriend(String standFriend){
            this.obj.setStandFriend(standFriend);
            return this;
        }
        public Builder photos(String photos){
            this.obj.setPhotos(photos);
            return this;
        }
        public Builder department(String department){
            this.obj.setDepartment(department);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder rejectReason(String rejectReason){
            this.obj.setRejectReason(rejectReason);
            return this;
        }
        public Builder dongdong(String dongdong){
            this.obj.setDongdong(dongdong);
            return this;
        }
        public Builder wxNumber(String wxNumber){
            this.obj.setWxNumber(wxNumber);
            return this;
        }
        public Builder create(java.time.LocalDateTime create){
            this.obj.setCreate(create);
            return this;
        }
        public Builder modified(java.time.LocalDateTime modified){
            this.obj.setModified(modified);
            return this;
        }
        public Builder ext(String ext){
            this.obj.setExt(ext);
            return this;
        }
        public Builder doingTags(String doingTags){
            this.obj.setDoingTags(doingTags);
            return this;
        }
        public Builder planTags(String planTags){
            this.obj.setPlanTags(planTags);
            return this;
        }
        public Builder activityTags(String activityTags){
            this.obj.setActivityTags(activityTags);
            return this;
        }
        public UserInfo build(){return obj;}
    }

}
