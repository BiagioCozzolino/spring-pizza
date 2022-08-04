const addBtn = document.getElementById('add');
addBtn.addEventListener('click', addUser);

let count = 0;
function addUser() {
  axios
    .get('http://localhost:8080/api/pizza')
    .then(function (response) {
        createUser(response.data[count])
        count ++
      
    })
    .catch(function (error) {
      
      console.log(error);
    });
}
// aggiunge alla gallery una img con la src passata come parametro
function createUser(data) {
  const div = document.createElement('div');
  div.classList.add("card","col-2","mx-3","shadow-lg")
  const title = document.createElement('h3');
  title.innerHTML = data.nome ;
  const description = document.createElement('p');
  description.innerHTML = data.descrizione;
  title.className = "card-title"
  const cardBody = document.createElement('div');
  cardBody.className = "card-body"
  description.className= "card-text"
  div.appendChild(cardBody);
  cardBody.appendChild(title);
  cardBody.appendChild(description);
  
  document.getElementById('gallery').appendChild(div);
}