var index = 0;
var answers = [];
var isHost = false;
var fields=[
  `
  <label>Email</label>
  <input type="email" name="email" class="form-control" value="" placeholder="email@example.com" required> <br>
  <label>Password</label>
  <input type="password" name="pass" class="form-control" value="" placeholder="Password" required> <br>
  <label>Type</label>
  <select class="custom-select" name="type" required>
      <option id="type" value="host">Host</option>
      <option id="type" value="guest">Caretaker</option>
  </select>`,

  `
  <label>First name</label>
  <input type="text" name="fname" class="form-control" value="" required><br>
  <label>Last name</label>
  <input type="text" name="lname" class="form-control" value="" required> <br>
  <label>Gender</label>
  <select class="custom-select" name="" required>
      <option id="gender" value="male">Male</option>
      <option id="gender" value="female">Female</option>
      <option id="gender" value="other">Other</option>
  </select> <br><br>

  <label>Age</label>
  <input type="number" name="age" class="form-control" value="" required> <br>`,
  `
  <label>Skype</label>
  <input type="text" name="skype" class="form-control" value=""> <br>
  <label>Phone</label>
  <input type="text" name="phone" class="form-control" value=""> <br>`,
  `
  <label>Dietary Restriction</label>
  <c:forEach var="diet" items="\${alldiets}">
      <input type="checkbox" name="dres" value=\${diet.restriction_name}>\${diet.restriction_name}<br>
  </c:forEach>

  <label>Language</label>
      <input type="checkbox" name="language" value="English">English<br>
      <input type="checkbox" name="language" value="Mandarin">Mandarin<br>
      <input type="checkbox" name="language" value="Japanese">Japanese<br>
      <input type="checkbox" name="language" value="Arabic">Arabic<br>
      <input type="checkbox" name="language" value="French">French<br>
      <input type="checkbox" name="language" value="Spanish">Spanish<br>`,
  `
  <label>Bio</label>
  <textarea name="bio" class="form-control" rows="8" cols="80"></textarea>`
];
var formHTML = document.getElementById("formHTML");
formHTML.innerHTML = fields[index];
function next(){
  //console.log("index: " + index + "field Length: " + fields.length);

  if(index + 1 < (isHost ? fields.length-2 : fields.length)){
    index++;
    let inputs = document.getElementsByTagName("input");
    var x = document.getElementsByTagName("select")[0];
    if(x !== undefined){
      //console.log(x.options[x.selectedIndex]);
      if(x.options[x.selectedIndex].value === "host"){
        isHost = true;
      }
      answers.push({
        "name": x.options[x.selectedIndex].id,
        "value": x.options[x.selectedIndex].value
      });

    }
    for(let i = 0; i < inputs.length;i++ ){


      if(inputs[i].type !== "checkbox"){
        answers.push({
          "name": inputs[i].name,
          "value": inputs[i].value
        });
      }else if(inputs[i].checked === true){
          answers.push({
            "name": inputs[i].name,
            "value": inputs[i].value
          });

      }

    }
    formHTML.innerHTML = fields[index];


  }else{
    if(document.getElementsByTagName("textarea")[0] != undefined){
      answers.push({
        "name": "bio",
        "value": document.getElementsByTagName("textarea")[0].value
      });
    }else{
      let inputs = document.getElementsByTagName("input");
      for(let i = 0; i < inputs.length;i++ ){


        if(inputs[i].type !== "checkbox"){
          answers.push({
            "name": inputs[i].name,
            "value": inputs[i].value
          });
        }else if(inputs[i].checked === true){
            answers.push({
              "name": inputs[i].name,
              "value": inputs[i].value
            });

        }

      }
    }

submitForm();
  }
  console.log(answers);

}
function previous(){
  if(index - 1 >= 0){
    let inputs = document.getElementsByTagName("input");
    var x = document.getElementsByTagName("select")[0];
    if(x !== undefined){
      console.log(x.options[x.selectedIndex]);
      answers.push({
        "name": x.options[x.selectedIndex].id,
        "value": x.options[x.selectedIndex].value
      });

    }
    for(let i = 0; i < inputs.length;i++ ){


      if(inputs[i].type !== "checkbox"){
        answers.push({
          "name": inputs[i].name,
          "value": inputs[i].value
        });
      }else if(inputs[i].checked === true){
          answers.push({
            "name": inputs[i].name,
            "value": inputs[i].value
          });

      }

    }
    index--;
    formHTML.innerHTML = fields[index];

  }
  console.log(answers);
}

function submitForm(){
  let form = document.createElement("form");
  form.method = "post";
  form.action = "RegisterController";
  for(let i = 0; i < answers.length; i++){
    let input = document.createElement("input");
    input.type = "hidden";
    input.name = answers[i].name;
    input.value = answers[i].value;
    form.appendChild(input);
  }
  document.getElementsByTagName("body")[0].appendChild(form);
  form.submit();
}
