<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>임산부 캘린더</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .calendar-container {
            margin-top: 20px;
        }
        .schedule-list, .vaccination-list {
            margin-top: 20px;
        }
        .date-display {
            margin-top: 20px;
            font-size: 1.2rem;
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp" />

<div class="container calendar-container">
    <h2 class="text-center">임산부 캘린더</h2>
    <div class="form-group">
        <label for="dueDate">출산일을 입력하세요:</label>
        <input type="date" class="form-control" id="dueDate" />
    </div>
    <button class="btn btn-primary" onclick="generateSchedule()">일정 생성</button>

    <div class="date-display" id="dateDisplay"></div>
    <div class="schedule-list"></div>
    <div class="vaccination-list"></div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp" />

<script>
    function generateSchedule() {
        const dueDateInput = document.getElementById('dueDate').value;
        const dueDate = new Date(dueDateInput);
        const today = new Date();
        const scheduleList = document.querySelector('.schedule-list');
        const vaccinationList = document.querySelector('.vaccination-list');
        const dateDisplay = document.getElementById('dateDisplay');

        // 유효성 검사
        if (!dueDateInput || dueDate < today) {
            alert('유효한 출산일을 입력하세요.');
            return;
        }

        // 현재 날짜와 출산일 표시
        const formattedToday = today.toLocaleDateString('ko-KR');
        const formattedDueDate = dueDate.toLocaleDateString('ko-KR');
        dateDisplay.innerHTML = `현재 날짜: ${formattedToday} / 출산일: ${formattedDueDate}`;

        // 병원 진료 일정 생성
        scheduleList.innerHTML = '<h3>병원 진료 일정</h3><ul>';
        let currentDate = new Date(today);
        while (currentDate <= dueDate) {
            const formattedDate = currentDate.toISOString().split('T')[0];
            scheduleList.innerHTML += `<li>${formattedDate} - 정기 진료</li>`;
            currentDate.setDate(currentDate.getDate() + 30); // 매달 진료 일정
        }
        scheduleList.innerHTML += '</ul>';

        // 아기 접종 정보 생성
        vaccinationList.innerHTML = '<h3>아기 접종 정보</h3><ul>';
        vaccinationList.innerHTML += '<li>출생 직후: B형 간염 백신</li>';
        vaccinationList.innerHTML += '<li>2개월: DTaP, IPV, Hib, PCV, RV</li>';
        vaccinationList.innerHTML += '<li>4개월: DTaP, IPV, Hib, PCV, RV</li>';
        vaccinationList.innerHTML += '<li>6개월: DTaP, IPV, Hib, PCV, RV</li>';
        vaccinationList.innerHTML += '<li>12개월: MMR, Varicella</li>';
        vaccinationList.innerHTML += '<li>15개월: DTaP</li>';
        vaccinationList.innerHTML += '<li>18개월: DTaP, IPV</li>';
        vaccinationList.innerHTML += '<li>4-6세: DTaP, IPV, MMR, Varicella</li>';
        vaccinationList.innerHTML += '</ul>';
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
