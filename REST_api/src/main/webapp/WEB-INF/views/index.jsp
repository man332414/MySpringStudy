<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>임산부 정보 웹사이트</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .logo img {
            height: 50px; /* 로고의 높이 조정 */
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp" />

<!-- 메인 배너 섹션 -->
<section class="container my-4">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5>산모 건강팁</h5>
                </div>
                <div class="card-body">
                    <h6>주차별 아기 발달 및 주요 산모 증상</h6>
                    <p>
                        임신 주차별로 아기의 발달 상황과 산모가 경험할 수 있는 주요 증상에 대한 정보를 제공합니다. 
                        예를 들어, 1주차부터 40주차까지의 변화와 체크리스트를 확인하세요.
                    </p>
                    <a href="#development-tips" class="btn btn-primary">자세히 알아보기</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5>2025년도 달라지는 산모 지원 시스템</h5>
                </div>
                <div class="card-body">
                    <p>
                        2025년부터 변경되는 산모 지원 정책과 프로그램에 대한 정보를 제공합니다. 
                        새로운 지원 내용과 자격 요건을 확인하여 필요한 지원을 받으세요.
                    </p>
                    <a href="#support-system" class="btn btn-primary">자세히 알아보기</a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- 영양 정보 섹션 -->
<section class="container my-4">
    <h2 class="text-center">임산부를 위한 영양 정보</h2>
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">
                    <h5>필수 영양소</h5>
                </div>
                <div class="card-body">
                    <ul>
                        <li><strong>엽산:</strong> 태아의 신경관 결함 예방에 중요합니다. 임신 초기부터 충분히 섭취해야 합니다.</li>
                        <li><strong>철분:</strong> 혈액 생성에 필요하며, 산모와 아기 모두에게 필수적입니다.</li>
                        <li><strong>칼슘:</strong> 아기의 뼈와 치아 형성에 필요하며, 산모의 뼈 건강에도 중요합니다.</li>
                        <li><strong>오메가-3 지방산:</strong> 두뇌 발달에 도움을 주며, 생선이나 견과류에서 섭취할 수 있습니다.</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">
                    <h5>추천 식단</h5>
                </div>
                <div class="card-body">
                    <p>다양한 음식을 포함한 균형 잡힌 식단이 중요합니다. 아래는 추천 식단입니다:</p>
                    <ul>
                        <li>아침: 오트밀, 바나나, 우유</li>
                        <li>점심: 퀴노아 샐러드, 닭가슴살, 야채</li>
                        <li>저녁: 연어 구이, 고구마, 브로콜리</li>
                        <li>간식: 요거트, 견과류, 신선한 과일</li>
                    </ul>
                    <p>각 식사는 영양소를 골고루 포함하도록 구성하세요.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp" />

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
