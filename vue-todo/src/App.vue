  <template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodo="addTodo"> </TodoInput>
    <TodoList v-bind:propsdata="todoItems" v-bind:num="num2" @removeTodo="removeTodo"></TodoList>
    <TodoFooter v-on:removeAll="clearAll"></TodoFooter>
  </div>
  </template>

  <script>
  import TodoHeader from'./components/TOdoHeader.vue'
  import TodoInput from'./components/TodoInput.vue'
  import TodoList from'./components/TodoList.vue'
  import TodoFooter from'./components/TodoFooter.vue'
  export default {
    data() {

   return {
     todoItems: [],
     num2:[]
   }
 },
 methods: {
   addTodo(todo,time) {
     let num = this.num2;

     this.todoItems.push("<할일> : "+todo +" <계획시간> : "+time);
     console.log(todo);
     axios.get("http://localhost:8888/Todo/jsp/todowriteproc.jsp?todo="+todo+"&time="+time ,
      {xhrFields : {withCredentials: true}})
   .then(function(response) {
     num.push(response.data.순번);
   console.log(response);
   })
   .catch(function(error) {
   console.log(error);
   })
 },
   clearAll() {
     localStorage.clear();
     this.todoItems = [];
   },
   removeTodo(todoItem, index, num) {
     //localStorage.removeItem(todoItem);
     this.todoItems.splice(index, 1);

     axios.get("http://localhost:8888/Todo/jsp/todoDelete.jsp?num="+num,
      {xhrFields : {withCredentials: true}})
    .then(function(response) {
    console.log(response);
    })
    .catch(function(error) {
    console.log(error);
    })

   },
   todoList(){
     let listItems = this.todoItems;
     let num = this.num2;
     axios.post("http://localhost:8888/Todo/jsp/todolist.jsp?num="+num, {xhrFields : {withCredentials: true}})
       .then(function(response) {
         console.log(response);
         let responseLength = response.data.length;
           for(let i=0; i < responseLength; i++){
             num.push(response.data[i].순번 );
             listItems.push("<할일> : "+response.data[i].할일 +" <계획시간> : "+response.data[i].시간);
           }
       })
       .catch(function(error) {
         console.log(error);
       })
   }
 },
 created() {
   this.todoList();
   // var storageLength = localStorage.length;
   // if (storageLength > 0) {
   //   for (var i = 0; i < storageLength; i++) {
   //     this.todoItems.push(localStorage.key(i));
   //   }
   // }
 },

    components:{
      'TodoHeader': TodoHeader,
      'TodoInput': TodoInput,
      'TodoList': TodoList,
      'TodoFooter': TodoFooter
    }
  }
  </script>

  <style>
  body{
    text-align: center;
    background-color: #F6F6F8
  }
    input{
      border-style:groove;
      width:200px;
    }
    button{
      border-style: groove;
    }
    .shadow{
      box-shadow: 5px 10px 10px rgba(0,0,0,0.03)
    }
  </style>
