const doctors = [
  {
    id: 0,
    name: "Самакаева Алина Викторовна",
    ageWork: 10,
    special: "Стоматолог-терапевт",
    description:
      "Постоянно повышаю свои знания. Использую в работе новейшие технологии и материалы. Главное качественное лечение и довольные клиенты. Окончила Чувашский государственный университет им. И.Н. Ульянова (стоматология) (2001 г.).",
  },
  {
    id: 1,
    name: "Григорьева Оксана Владимировна",
    ageWork: 6,
    special: "Стоматолог-терапевт",
    description:
      "Специализируюсь на лечении зубов и предупреждении их заболеваний. Постоянно обучаюсь и применяю современные методы лечения. Окончила Московский государственный медико-стоматологический университет (стоматология) (2015 г.).",
  },
  {
    id: 2,
    name: "Иванова Елена Александровна",
    ageWork: 15,
    special: "Стоматолог-ортопед",
    description:
      "Стремлюсь к достижению идеального результата в восстановлении зубов. Постоянно обучаюсь и следую последним тенденциям в стоматологии. Окончила Московский государственный медико-стоматологический университет (стоматология) (2005 г.).",
  },
  {
    id: 3,
    name: "Петрова Анна Сергеевна",
    ageWork: 8,
    special: "Стоматолог-хирург",
    description:
      "Специализируюсь на хирургическом удалении зубов и имплантации. Постоянно повышаю свою квалификацию и применяю современные методы лечения. Окончила Российский университет дружбы народов (стоматология) (2013 г.).",
  },
  {
    id: 4,
    name: "Сидорова Ольга Николаевна",
    ageWork: 12,
    special: "Стоматолог-ортодонт",
    description:
      "Специализируюсь на коррекции прикуса и выравнивании зубов. Постоянно совершенствую свои навыки и использую самые современные методики. Окончила Санкт-Петербургский государственный медицинский университет (стоматология) (2007 г.).",
  },
  {
    id: 5,
    name: "Кузнецов Дмитрий Алексеевич",
    ageWork: 10,
    special: "Стоматолог-пародонтолог",
    description:
      "Специализируюсь на лечении заболеваний пародонта и тканей околозубной. Постоянно повышаю свою квалификацию и применяю инновационные методы лечения. Окончил Санкт-Петербургский государственный медицинский университет (стоматология) (2011 г.).",
  },

  {
    id: 6,
    name: "Михайлова Екатерина Ивановна",
    ageWork: 7,
    special: "Стоматолог-ортопед",
    description:
      "Занимаюсь восстановлением зубов и изготовлением протезов. Следую последним достижениям в области стоматологии и применяю новейшие технологии. Окончила Московский государственный медико-стоматологический университет (стоматология) (2014 г.).",
  },
  {
    id: 7,
    name: "Смирнова Мария Владимировна",
    ageWork: 9,
    special: "Стоматолог-терапевт",
    description:
      "Специализируюсь на лечении зубов и предупреждении их заболеваний. Постоянно обучаюсь и применяю современные методы лечения. Окончила Санкт-Петербургский государственный медицинский университет (стоматология) (2012 г.).",
  },
  {
    id: 8,
    name: "Николаева Анастасия Александровна",
    ageWork: 11,
    special: "Стоматолог-ортодонт",
    description:
      "Специализируюсь на коррекции прикуса и выравнивании зубов. Постоянно совершенствую свои навыки и применяю инновационные методики. Окончила Московский государственный медико-стоматологический университет (стоматология) (2006 г.).",
  },
  {
    id: 9,
    name: "Козлов Алексей Сергеевич",
    ageWork: 13,
    special: "Стоматолог-хирург",
    description:
      "Занимаюсь хирургическим удалением зубов и имплантацией. Постоянно повышаю свою квалификацию и применяю новейшие методы лечения. Окончил Санкт-Петербургский государственный медицинский университет (стоматология) (2008 г.).",
  },
  {
    id: 10,
    name: "Васильев Андрей Игоревич",
    ageWork: 14,
    special: "Стоматолог-ортопед",
    description:
      "Занимаюсь восстановлением зубов и изготовлением протезов. Постоянно совершенствую свои навыки и применяю инновационные методики. Окончил Санкт-Петербургский государственный медицинский университет (стоматология) (2007 г.).",
  },
];

const doctorItems = document.querySelectorAll(".doctor");

// <div className="doctorInfo__block">
//   <div className="doctorInfo__image">
//     <img src="" alt="">
//   </div>
//   <div className="doctorInfo__info">
//     <div className="doctorInfo__name"></div>
//     <div className="doctorInfo__special"></div>
//     <div className="doctorInfo__ageWork"></div>
//     <div className="doctorInfo__description></div
//   </div>
// </div>

const doctorIdInput = document.querySelector('input')

const doctorImageBlock = document.querySelector(".doctorInfo__image");
const doctorNameBlock = document.querySelector(".doctorInfo__name");
const doctorSpecialBlock = document.querySelector(".doctorInfo__special");
const doctorAgeWorkBlock = document.querySelector(".doctorInfo__ageWork");
const doctorDescriptionBlock = document.querySelector(
  ".doctorInfo__description",
);
const form = document.querySelector('form');



doctorItems.forEach((currentDoctor) => {
  currentDoctor.addEventListener("click", () => {
    const doctorName = currentDoctor.querySelector(".doctor__name");
    const objectDoctor = doctors.filter((item) => {
      if (item.name === doctorName.innerHTML) return item;
    });
    const doctorImage = doctorImageBlock.querySelector("img");
    doctorImage.setAttribute("src", "./img/doctor" + objectDoctor[0].id + ".jpeg");
    currentDoctor.classList.add("active-item");
    doctorNameBlock.innerHTML = objectDoctor[0].name;
    doctorSpecialBlock.innerHTML = objectDoctor[0].special;
    doctorIdInput.value = objectDoctor[0].id;
    form.style.display = "block"
    doctorAgeWorkBlock.innerHTML = "Опыт работы (в годах): " + objectDoctor[0].ageWork;
    doctorDescriptionBlock.innerHTML = objectDoctor[0].description;
    doctorItems.forEach((doctor) => {
      if (doctor !== currentDoctor) doctor.classList.remove("active-item");
    });
  });
});
