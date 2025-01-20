<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지식의 숲</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/main01.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main/footer.css">
    <script src="${pageContext.request.contextPath}/asset/js/main/main.js"></script>
</head>


<body>
	<!-- 헤더 - 메뉴바 -->
	<jsp:include page="/html/main/header.jsp" />
	
	

    <!-- 위시 리스트 -->
    <main>
        <div class="main-div-wrapper">
            <div class="main-div-wishlist">
                <h2 style="text-align: center;">
                    <img src="${pageContext.request.contextPath}/asset/img/main/pencil.png" alt="Atlas Icon"
                        style="width: 40px; height: 40px;  margin-right: 5px;">
                    Forest of Knowledge
                </h2>
                <div class="main-div-wishlistcontainer">
                    <div class="main-div-wishlistcontent">
                        <div class="main-div-wishlisttitle">
                            <h2>MY</h2>
                            <br>
                            <h2>WISH</h2>
                            <h2>LIST</h2>
                        </div>
                        <ul class="main-div-ulist">
                            <li>로그인 후 이용 부탁 드립니다.</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="main-div-banner">
                <div class="main-div-slide1">
                    <img src="${pageContext.request.contextPath}/asset/img/main/banner01.png" alt="이미지1"
                        class="main-img-banner01 main-div-banneractive">
                </div>
                <div class="main-div-slide2">
                    <img src="${pageContext.request.contextPath}/asset/img/main/banner02.png" alt="이미지2" class="main-img-banner02">
                </div>
                <div class="main-div-slide3">
                    <img src="${pageContext.request.contextPath}/asset/img/main/banner03.png" alt="이미지3" class="main-img-banner03">
                </div>

            </div>
        </div>

        <!-- 신규/마감 임박 스터디 -->
        <main class="main-div-container">
            <div class="main-div-studycard main-div-studynew">
                <header class="main-div-studycardheader">
                    <span class="main-span-label">NEW </span>
                    <span class="main-span-title"> 신규 등록 스터디</span>
                </header>
                <div class="main-div-studycontent">
                    <!-- <a href="#" onclick="notLogin(this)"> -->
                    <div class="main-div-studyitem "  onclick="notLogin(this)">
                        <span class="main-span-icon">[개발]</span>
                        <div class="main-div-studyname">영국에서 HGXWCH이라는 사람은 1930년에 이 편지를 받았습니다. 그는 비서에게 복사해서 보내라고 했습니다. 며칠 뒤에 복권이 당첨되어 20억을 받았습니다</div>
                        <div class="main-div-studytext">이 편지는 영국에서 최초로 시작되어 일년에 한바퀴를 돌면서 받는 사람에게 행운을 주었고 지금은 당신에게로 옮겨진 이 편지는 4일 안에 당신 곁을 떠나야 합니다. 이 편지를 포함해서 7통을 행운이 필요한 사람에게 보내
                        주셔야 합니다. 복사를 해도 좋습니다. 혹 미신이라 하실지 모르지만 사실이 아니지롱.</div>
                    </div>
                </a>
                <!-- <a href="#" onclick="notLogin(this)"> -->
                    <div class="main-div-studyitem"  onclick="notLogin(this)">
                        <span class="main-span-icon">[보안]</span>
                        <div class="main-div-studyname">보안 스터디 ㅋㅋ</div>
                        <div class="main-div-studytext">여긴 보안 내용이네.</div>
                    </div>
                </a>
                </div>
            </div>
            <div class="main-div-studycard main-div-studyhurry">
                <header class="main-div-studycardheader">
                    <span class="main-span-label">Hurry </span>
                    <span class="main-span-title"> 마감 임박 스터디</span>
                </header>
                <div class="main-div-studycontent">
                    <!-- <a href="#" onclick="notLogin(this)"> -->
                        <div class="main-div-studyitem" onclick="notLogin(this)">
                            <span class="main-span-icon">[보안]</span>
                            <div class="main-div-studyname">ㅋㅋ</div>
                            <div class="main-div-studytext">내용입니다.</div>
                        </div>
                    </a>
                    <!-- <a href="#" onclick="notLogin(this)"> -->
                        <div class="main-div-studyitem" onclick="notLogin(this)">
                            <span class="main-span-icon">[개발]</span>
                            <div class="main-div-studyname">너만 오면 시작</div>
                            <div class="main-div-studytext">대충 구한다는 내용.</div>
                        </div>
                    <!-- </a> -->
                </div>
            </div>
        </main>

	<!-- 푸터 -->
	<jsp:include page="/html/main/footer.jsp"/>
	

</body>

</html>