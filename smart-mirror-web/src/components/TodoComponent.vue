<template>
    <div class="todo">
        <div class="today-tasks">
            <h3>当日提醒事项 {{ todayTasks.length }} 项</h3>
            <ul>
                <li v-for="(task, index) in todayTasks" :key="index" class="task-item">
                    <span v-if="task.priority" class="priority-dot"></span>
                    <span>{{ task.summary }}</span>
                </li>
            </ul>
        </div>
        <div class="future-tasks">
            <h3>待提醒事项</h3>
            <ul>
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

export default {
    name: 'TodoComponent',
    data() {
        return {
            todayTasks: [],
            futureTasks: []
        };
    },
    methods: {
        fetchTasks() {
            const apiUrl = 'http://localhost:5091/api/tasks';

            axios.get(apiUrl)
                .then(response => {
                    console.log('Response:', response.data);
                    this.todayTasks = response.data.todayTasks;
                    this.futureTasks = response.data.futureTasks;
                })
                .catch(error => {
                    console.error('Error fetching tasks:', error);
                });
        }
    },
    mounted() {
        this.fetchTasks();
    }
};
</script>
<style scoped>
.todo {
    width: 40%;
    height: calc(100vh - 50px);
    border-right: 1px solid #000;
    float: left;
    box-sizing: border-box;
}

.today-tasks,
.future-tasks {
    padding: 10px;
}

.today-tasks ul,
.future-tasks ul {
    list-style-type: none;
    padding-left: 0;
}

.task-item {
    display: flex;
    align-items: center;
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