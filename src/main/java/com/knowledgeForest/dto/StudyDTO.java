package com.knowledgeForest.dto;

public class StudyDTO {

   /*
    * -INSERT INTO TBL_STUDY ( 
    * STUDY_NUM 
    * , USER_NUM 
    * , STUDY_TITLE 
    * , STUDY_DESCRIPT
    * , STUDY_LOCATION 
    * , STUDY_START_DAY 
    * , STUDY_END_DAY 
    * , STUDY_START_TIME 
    * , STUDY_END_TIME 
    * , STUDY_LIMIT
    * , STUDY_DEADLINE 
    * , STUDY_SHOWPH 
    * , STUDY_CATEGORY
    * , STUDY_UPLOAD_DATE 
    * , STUDY_EDIT_DATE)
    *  VALUES (1, 17, 'dolorum 스터디',
    * 'Assumenda veritatis architecto sunt illo. 스터디입니다.', '정선군 백제고분',
    * TO_DATE('2025-01-21', 'YYYY-MM-DD'), TO_DATE('2025-01-29', 'YYYY-MM-DD'),
    * '14:00', '23:00', 16, TO_DATE('2025-01-17', 'YYYY-MM-DD'), 0, 1,
    * TO_DATE('2025-01-12', 'YYYY-MM-DD'), TO_DATE('2025-01-12', 'YYYY-MM-DD'));
    * 
    */
   
   private int studyNum;
   private int userNum;
   private String studyTitle;
   private String studyDescript;
   private String studyLocation;
   private String studyStartDay;
   private String studyEndDay;
   private String studyStartTime;
   private String studyEndTime;
   private int studyLimit;
   private String studyDeadline;
   private int studyShowph;
   private int studyCategory;
   private String studyUploadDate;
   private String studyEditDate;

   public int getStudyNum() {
      return studyNum;
   }

   public void setStudyNum(int studyNum) {
      this.studyNum = studyNum;
   }

   public int getUserNum() {
      return userNum;
   }

   public void setUserNum(int userNum) {
//      this.userNum = userNum;
	   this.userNum = 11;
   }

   public String getStudyTitle() {
      return studyTitle;
   }

   public void setStudyTitle(String studyTitle) {
      this.studyTitle = studyTitle;
   }

   public String getStudyDescript() {
      return studyDescript;
   }

   public void setStudyDescript(String studyDescript) {
      this.studyDescript = studyDescript;
   }

   public String getStudyLocation() {
      return studyLocation;
   }

   public void setStudyLocation(String studyLocation) {
      this.studyLocation = studyLocation;
   }

   public String getStudyStartDay() {
      return studyStartDay;
   }

   public void setStudyStartDay(String studyStartDay) {
      this.studyStartDay = studyStartDay;
   }

   public String getStudyEndDay() {
      return studyEndDay;
   }

   public void setStudyEndDay(String studyEndDay) {
      this.studyEndDay = studyEndDay;
   }

   public String getStudyStartTime() {
      return studyStartTime;
   }

   public void setStudyStartTime(String studyStartTime) {
      this.studyStartTime = studyStartTime;
   }

   public String getStudyEndTime() {
      return studyEndTime;
   }

   public void setStudyEndTime(String studyEndTime) {
      this.studyEndTime = studyEndTime;
   }

   public int getStudyLimit() {
      return studyLimit;
   }

   public void setStudyLimit(int studyLimit) {
      this.studyLimit = studyLimit;
   }

   public String getStudyDeadline() {
      return studyDeadline;
   }

   public void setStudyDeadline(String studyDeadline) {
      this.studyDeadline = studyDeadline;
   }

   public int getStudyShowph() {
      return studyShowph;
   }

   public void setStudyShowph(int studyShowph) {
      this.studyShowph = studyShowph;
   }

   public int getStudyCategory() {
      return studyCategory;
   }

   public void setStudyCategory(int studyCategory) {
      this.studyCategory = studyCategory;
   }

   public String getStudyUploadDate() {
      return studyUploadDate;
   }

   public void setStudyUploadDate(String studyUploadDate) {
      this.studyUploadDate = studyUploadDate;
   }

   public String getStudyEditDate() {
      return studyEditDate;
   }

   public void setStudyEditDate(String studyEditDate) {
      this.studyEditDate = studyEditDate;
   }

   @Override
   public String toString() {
      return "StudyDTO [studyNum=" + studyNum + ", userNum=" + userNum + ", studyTitle=" + studyTitle
            + ", studyDescript=" + studyDescript + ", studyLocation=" + studyLocation + ", studyStartDay="
            + studyStartDay + ", studyEndDay=" + studyEndDay + ", studyStartTime=" + studyStartTime
            + ", studyEndTime=" + studyEndTime + ", studyLimit=" + studyLimit + ", studyDeadline=" + studyDeadline
            + ", studyShowph=" + studyShowph + ", studyCategory=" + studyCategory + ", studyUploadDate="
            + studyUploadDate + ", studyEditDate=" + studyEditDate + "]";
   }
   
}
