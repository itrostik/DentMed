let messages = document.querySelectorAll(".message");
const bufferMessages = []
messages.forEach((message) => {
    bufferMessages.push(message)
})


bufferMessages.sort((a, b) => compare(a.querySelector('.message__info').children[1].innerHTML, b.querySelector('.message__info').children[1].innerHTML))

// const sortedDates = bufferMessages.sort((a, b) => {
//     const dateA = a.split(" ")[0]
//     const dateB = b.split(" ")[0]
//
//     if (dateA < dateB) {
//         return -1;
//     }
//     if (dateA > dateB) {
//         return 1;
//     }
// })

// bufferMessages.sort(compare)

function compare(a, b) {
    let dateA = new Date(a)
    let dateB = new Date(b)
    return dateA - dateB;
}

bufferMessages.forEach(item => {
    console.log(item)
})

const messagesBlock = document.querySelector(".messages")

messagesBlock.replaceChildren(...bufferMessages)
