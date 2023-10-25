let servicesItems = document.querySelectorAll(".services-block-item");

servicesItems.forEach((element) => {
  element.addEventListener("click", () => {
    const parent = element.parentNode;
    const icon = parent.querySelector(".services-block-icon");
    if (parent.classList.value.includes("open-block")) {
      parent.classList.add("close-block");
    } else {
      parent.classList.remove("close-block");
    }
    icon.classList.toggle("rotate-icon");
    parent.classList.toggle("open-block");
  });
});

const modal = document.querySelector('.modal')
const wrapper = document.querySelector(".wrapper")
const swiperButtons = document.querySelectorAll(".modal__openButton")

const closeButton = document.querySelector(".сlose__modal")

swiperButtons.forEach(elem => {
  elem.addEventListener("click", () => {
    modal.classList.add('modal-open');
    wrapper.style.display = "none";
  })
})

closeButton.addEventListener('click', () => {
  modal.classList.remove('modal-open')
  wrapper.style.display = "flex";
})
