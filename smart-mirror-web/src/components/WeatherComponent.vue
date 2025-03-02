<template>
    <div class="weather-component">
        <!-- 第一行 -->
        <div class="current-weather">
            <!-- 当前天气图标与温度 -->
            <div class="weather-info">
                <img :src="weatherIcon" alt="Weather Icon" class="weather-icon" />
                <span class="temperature">{{ temperature }}°</span>
            </div>

            <!-- 实时时间、周几（上下布局） -->
            <div class="time-and-day">
                <span class="time">{{ currentTime }}</span>
                <span class="day-of-week">{{ dayOfWeek }}</span>
            </div>

            <!-- 日期和农历日期（上下布局） -->
            <div class="date-and-lunar">
                <span class="date">{{ date }}</span>
                <span class="lunar-date">{{ lunarDate }}</span>
            </div>
        </div>

        <!-- 第二行 -->
        <div class="weekly-forecast">
            <div v-for="(day, index) in weeklyWeather" :key="index" class="forecast-day">
                <span class="forecast-day-name">{{ day.dayOfWeek }}</span>
                <img :src="day.weatherIcon" alt="Weather Icon" class="forecast-icon" />
                <div class="temp-range">
                    <span class="forecast-temp-low">{{ day.temperatureLow }}</span> /
                    <span class="forecast-temp-high">{{ day.temperatureHigh }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { onBeforeUnmount } from 'vue';
import { Lunar } from 'lunar-javascript';

import axios from 'axios';

export default {
    name: 'WeatherComponent',
    data() {
        return {
            location: '440305',
            apiKey: process.env.VUE_APP_AMAP_API_KEY,
            weatherIcon: '',
            temperature: '',
            currentTime: new Date().toLocaleTimeString('zh-CN', { hour12: false }),
            dayOfWeek: new Date().toLocaleDateString('zh-CN', { weekday: 'long' }),
            date: new Date().toLocaleDateString('zh-CN'),
            lunarDate: '',
            weeklyWeather: [],
            weatherTimer: null,
            timeTimer: null,
        };
    },
    methods: {
        fetchLiveData() {
            const url = `https://restapi.amap.com/v3/weather/weatherInfo?key=${this.apiKey}&city=${this.location}&extensions=base`;

            axios.get(url)
                .then(response => {
                    if (response.data.status === '1') {
                        const liveData = response.data.lives[0];
                        this.temperature = liveData.temperature;
                        this.weatherIcon = this.getWeatherIcon(liveData.weather);
                        this.updateLunarDate();
                    } else {
                        console.error('Error fetching live weather data:', response.data.info);
                    }
                })
                .catch(error => {
                    console.error('There was an error fetching the live weather data!', error);
                });
        },
        fetchForecastData() {
            const url = `https://restapi.amap.com/v3/weather/weatherInfo?key=${this.apiKey}&city=${this.location}&extensions=all`;

            axios.get(url)
                .then(response => {
                    if (response.data.status === '1') {
                        this.updateWeeklyForecast(response.data.forecasts[0].casts);
                    } else {
                        console.error('Error fetching forecast weather data:', response.data.info);
                    }
                })
                .catch(error => {
                    console.error('There was an error fetching the forecast weather data!', error);
                });
        },
        updateWeeklyForecast(casts) {
            this.weeklyWeather = casts.map(day => ({
                dayOfWeek: new Date(day.date).toLocaleDateString('zh-CN', { weekday: 'long' }),
                weatherIcon: this.getWeatherIcon(day.dayweather),
                temperatureLow: day.nighttemp,
                temperatureHigh: day.daytemp
            }));
        },
        getWeatherIcon(weatherDescription) {
            const iconMap = {
                '晴': require('@/assets/W0.png'),
                '多云': require('@/assets/W2.png'),
                '少云': require('@/assets/W2.png'),
                '阴': require('@/assets/W2.png'),
                '晴间多云': require('@/assets/W1.png'),
                '阵雨': require('@/assets/W3.png'),
                '强阵雨': require('@/assets/W3.png'),
                '雷阵雨': require('@/assets/W4.png'),
                '强雷阵雨': require('@/assets/W4.png'),
                '雷阵雨伴有冰雹': require('@/assets/W5.png'),
                '小雨': require('@/assets/W7.png'),
                '中雨': require('@/assets/W8.png'),
                '大雨': require('@/assets/W19.png'),
                '极端降雨': require('@/assets/W7.png'),
                '毛毛雨/细雨': require('@/assets/W7.png'),
                '暴雨': require('@/assets/W19.png'),
                '大暴雨': require('@/assets/W19.png'),
                '特大暴雨': require('@/assets/W19.png'),
                '雨': require('@/assets/W7.png'),
                '小雪': require('@/assets/W14.png'),
                '中雪': require('@/assets/W15.png'),
                '大雪': require('@/assets/W16.png'),
                '暴雪': require('@/assets/W17.png'),
                '雨夹雪': require('@/assets/W6.png'),
                '雨雪天气': require('@/assets/W6.png'),
                '阵雨夹雪': require('@/assets/W6.png'),
                '阵雪': require('@/assets/W13.png'),
                '雪': require('@/assets/W17.png'),
                '薄雾': require('@/assets/W18.png'),
                '雾': require('@/assets/W18.png'),
                '霾': require('@/assets/W29.png'),
                '扬沙': require('@/assets/W45.png'),
                '浮尘': require('@/assets/W45.png'),
                '沙尘暴': require('@/assets/W45.png'),
                '强沙尘暴': require('@/assets/W45.png'),
                '未知': require('@/assets/W44.png'),
            };
            return iconMap[weatherDescription] || require('@/assets/W44.png');
        },
        updateLunarDate() {
            const now = new Date();
            const lunar = Lunar.fromDate(now); 
            this.lunarDate =lunar.getYearInGanZhi() + "年" +lunar.getMonthInChinese()+ "月" + lunar.getDayInChinese();
            const jq = lunar.getCurrentJieQi();
            if(jq){
                this.lunarDate += "("+ jq +")" ;
            }
        },
        updateTimeAndDate() {
            this.currentTime = new Date().toLocaleTimeString('zh-CN', { hour12: false });
            this.dayOfWeek = new Date().toLocaleDateString('zh-CN', { weekday: 'long' });
            this.date = new Date().toLocaleDateString('zh-CN');
        },
        startAutoUpdate() {
            // 实时更新时间的定时器
            this.timeTimer = setInterval(() => {
                this.updateTimeAndDate(); // 每秒更新当前时间
            }, 1000);

            // 更新实时天气数据的定时器
            this.weatherTimer = setInterval(() => {
                this.fetchLiveData(); // 每小时获取实时天气数据
                this.fetchForecastData();
            }, 60 * 60 * 1000); // 每隔一小时执行一次

            // 立即执行一次以初始化数据
            this.fetchLiveData();
            this.fetchForecastData();
            this.updateTimeAndDate();
        }
    },
    mounted() {
        this.startAutoUpdate();
    },
    setup() {
        onBeforeUnmount(() => {
            if (this.weatherTimer) {
                clearInterval(this.weatherTimer); // 清除天气数据更新定时器
            }
            if (this.timeTimer) {
                clearInterval(this.timeTimer); // 清除时间更新定时器
            }
        });
    }
};
</script>

<style scoped>
.weather-component {
    font-family: Arial, sans-serif;
}

.current-weather {
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 10px;
}

.weather-info {
    display: flex;
    align-items: center;
}

.weather-icon {
    width: 60px;
    height: 60px;
    margin-right: 10px;
}

.temperature {
    font-size: 45px;
}

.time-and-day {
    font-size: 40px;
}

.time-and-day .time {
    padding-right: 10px;
}

.date-and-lunar {
    display: flex;
    flex-direction: column;
    justify-content: center;
    text-align: center;
}

.date,
.lunar-date {
    font-size: 30px;
}

.weekly-forecast {
    display: flex;
    justify-content: space-around;
    padding: 10px;
}

.forecast-day {
    text-align: center;
    flex: 1;
    padding: 10px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.forecast-day-name,
.temp-range {
    font-size: 30px;
}

.forecast-icon {
    width: 70px;
    height: 70px;
    margin: 10px auto;
}

</style>