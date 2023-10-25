const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const login = document.getElementById("login");
const password = document.getElementById("password");
const address = document.getElementById("address");
const email = document.getElementById("email");
const button = document.getElementById("button");
const phoneNumber = document.getElementById("number");

firstName.addEventListener("input", () => {
  const regex = /^([А-Яа-я]+)$/;
  if (regex.test(firstName.value) && firstName.value.length <= 100) {
    firstName.classList.remove("danger");
    disabled();
  } else {
    firstName.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

lastName.addEventListener("input", () => {
  const regex = /^([а-яА-Я]+)$/;
  if (regex.test(lastName.value) && lastName.value.length <= 100) {
    lastName.classList.remove("danger");
    disabled();
  } else {
    lastName.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

login.addEventListener("input", () => {
  const regex = /^([a-zA-Z0-9_.]+).{3,}$/;
  if (regex.test(login.value) && login.value.length <= 40) {
    login.classList.remove("danger");
    disabled();
  } else {
    login.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

password.addEventListener("input", () => {
  const regex = /^(?=.*[a-zA-Z])(?=.*\d).{5,}$/;
  if (regex.test(password.value) && password.value.length <= 40) {
    password.classList.remove("danger");
    disabled();
  } else {
    password.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

address.addEventListener("input", () => {
  const regex = /^([А-Яа-я0-9,.]+).{3,}$/;
  if (regex.test(address.value) && address.value.length <= 300) {
    address.classList.remove("danger");
    disabled();
  } else {
    address.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

email.addEventListener("input", () => {
  const regex = /([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9_-]+)/;
  if (regex.test(email.value) && email.value.length <= 100) {
    email.classList.remove("danger");
    disabled();
  } else {
    email.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

phoneNumber.addEventListener("input", () => {
  const regex =
    /^(\+7|8)?[\s-]?\(?[489][0-9]{2}\)?[\s-]?[0-9]{3}[\s-]?[0-9]{2}[\s-]?[0-9]{2}$/;
  if (regex.test(phoneNumber.value) && phoneNumber.value.length <= 20) {
    phoneNumber.classList.remove("danger");
    button.removeAttribute("disabled");
    disabled();
  } else {
    phoneNumber.classList.add("danger");
    button.setAttribute("disabled", "disabled");
  }
});

function disabled() {
  if (
    email.value &&
    firstName.value &&
    lastName.value &&
    password.value &&
    login.value &&
    address.value &&
    phoneNumber.value
  ) {
    button.removeAttribute("disabled");
  } else {
    button.setAttribute("disabled", "disabled");
  }
}
