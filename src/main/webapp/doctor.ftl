<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/doctors.css">
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main __container">
    <div class="doctorInfo__block">
      <div class="doctorInfo__image">
        <img src="./img/doctor${doctor.doctorId}.jpeg" alt="">
      </div>
      <div class="doctorInfo__info">
        <div class="doctorInfo__name">${doctor.name}</div>
        <div class="doctorInfo__special">${doctor.special}</div>
        <div class="doctorInfo__ageWork">Опыт работы (в годах): ${doctor.ageWork}</div>
        <div class="doctorInfo__description">${doctor.description}</div>
      </div>
    </div>

    <div class="doctorInfo__reviews">
      <div class="doctorInfo__reviews-title">Отзывы</div>
        <div class="reviews">
            <#list reviews as review>
                <#list users as elem>
                    <#if review.userId == elem.userId>
                      <div class="review">
                        <span class="review__text">${review.reviewText}</span>
                        <span>${elem.firstName + " " + elem.lastName}</span>
                        <span>${review.reviewDate}</span>
                          <#if user??>
                              <#if elem.userId == review.userId>
                                <form action="/deleteReview">
                                  <input type="text" name="doctorId" value="${doctor.doctorId}" style="display: none">
                                  <input type="text" name="reviewId" value="${review.reviewId}"
                                         style="display: none">
                                  <button type="submit" class="review__delete">
                                    <img src="./img/multiply.svg" alt="">
                                  </button>
                                </form>
                              </#if>
                          </#if>
                      </div>
                    </#if>
                </#list>
            </#list>
        </div>
    </div>
    <form action="/doctor" method="post">
      <input type="text" name="doctorId" value="${doctor.doctorId}" style="display: none">
      <input type="text" name="review" class="doctor__input" placeholder="Напишите отзыв">
        <#if user??>
          <button type="submit" class="doctor__button">Написать отзыв</button>
        <#else>
          <a href="/login" class="doctor__button" style="color: #ffffff">Написать отзыв</a>
        </#if>
    </form>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
</body>
</html>