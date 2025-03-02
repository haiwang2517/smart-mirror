<template>
  <div class="todo">
    <div class="today-tasks">
      <h3>提醒事项</h3>
      <ul>
        <li v-for="(task, index) in todayTasks" :key="index" class="task-item">
          <span v-if="task.countdown == 0" class="priority-dot"></span>
          <span>{{ task.summary }} <span class="due-date">{{ task.countdown }} 天</span></span>
        </li>
        <li v-for="(task, index) in futureTasks" :key="index" class="task-item">
          <span v-if="task.priority" class="priority-dot"></span>
          <span>{{ task.summary }} <span class="due-date">{{ task.countdown }} 天</span></span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import {onBeforeUnmount} from 'vue';

export default {
  name: 'TodoComponent',
  data() {
    return {
      todayTasks: [],
      futureTasks: [],
      timeTimer: null
    };
  },
  methods: {
    fetchTasks() {
      const apiUrl = '/api/tasks';
      axios.get(apiUrl)
          .then(response => {
            console.log('Response:', response.data);
            this.todayTasks = response.data.todayTasks;
            this.futureTasks = response.data.futureTasks;
          })
          .catch(error => {
            console.error('Error fetching tasks:', error);
          });
    },
    startAutoUpdate() {
      this.timeTimer = setInterval(() => {
        this.fetchTasks(); // 每秒更新当前时间
      }, 30000);
    },
  },
  mounted() {
    this.fetchTasks();
    this.startAutoUpdate();
  },
  setup() {
    onBeforeUnmount(() => {
      if (this.timeTimer) {
        clearInterval(this.timeTimer); // 清除时间更新定时器
      }
    });
  }
};
</script>
<style scoped>
.todo {
  width: 40%;
  height: calc(100vh - 50px);
  border-right: 1px none ;
  float: left;
  box-sizing: border-box;
  padding: 10px;
}

.today-tasks,
.future-tasks {
  padding: 10px;
  font-size: 30px;
}

.today-tasks ul,
.future-tasks ul {
  list-style-type: none;
  padding-left: 0;
}

.task-item {
  display: flex;
  align-items: center;
  font-size: 20px;
  margin-bottom: 5px;
}

.priority-dot {
  display: inline-block;
  width: 8px;
  height: 8px;
  background-color: orange;
  border-radius: 50%;
  margin-right: 10px;
}

.due-date {
  margin-left: auto;
}
</style>