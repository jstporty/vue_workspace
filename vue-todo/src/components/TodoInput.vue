<template>
<div class="inputBox shadow">
  <input type="text" v-model="newTodoItem" placeholder="할일을 넣어주세요!" v-on:keyup.enter="addTodo">
  <input type="text" v-model="newTodoItem1" placeholder="시간" v-on:keyup.enter="addTodo">
  <span class="addContainer" v-on:click="addTodo">
    <i class="fas fa-plus" aria-hidden="true"></i>
  </span>
  <modal v-if="showModal" @close="showModal=false">
    <h3 slot="header">경고</h3>
    <span slot="footer" @click="showModal=false">
      할 일을 입력하세요 ㅋ;;;;;
      <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
    </span>
  </modal>
</div>
</template>

<script>
import Modal from './common/Modal.vue'

export default {
  props: ['propsdate'],

  data() {
    return {
      newTodoItem: '',
      newTodoItem1: '',
      showModal: false
    }
  },

  methods: {
    addTodo() {
      if (this.newTodoItem !== "" && this.newTodoItem !== "") {
        var todo = this.newTodoItem && this.newTodoItem.trim();
        var time = this.newTodoItem1 && this.newTodoItem1.trim();
        this.$emit("addTodo", todo,time);
        this.clearInput();
      } else {
        this.showModal = !this.showModal;
      }
    }, // addTodo
    clearInput() {
      this.newTodoItem = '';
      this.newTodoItem1 = '';
    } // clearInput
  },

  components: {
    Modal: Modal
  }

}
</script>

<style>
input: focus {
  outline: none;
}

.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}

.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}

.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}

.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
