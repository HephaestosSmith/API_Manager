<template>
	<el-form size="small">
		<el-form-item>
			<el-radio :label="1" v-model='radioValue'>
				不填，允許的萬用字元[, - * /]
			</el-radio>
		</el-form-item>

		<el-form-item>
			<el-radio :label="2" v-model='radioValue'>
				每年
			</el-radio>
		</el-form-item>

		<el-form-item>
			<el-radio :label="3" v-model='radioValue'>
				週期從
				<el-input-number v-model='cycle01' :min='fullYear' :max="2098" /> -
				<el-input-number v-model='cycle02' :min="cycle01 ? cycle01 + 1 : fullYear + 1" :max="2099" />
			</el-radio>
		</el-form-item>

		<el-form-item>
			<el-radio :label="4" v-model='radioValue'>
				從
				<el-input-number v-model='average01' :min='fullYear' :max="2098"/> 年開始，每
				<el-input-number v-model='average02' :min="1" :max="2099 - average01 || fullYear" /> 年執行一次
			</el-radio>

		</el-form-item>

		<el-form-item>
			<el-radio :label="5" v-model='radioValue'>
				指定
				<el-select clearable v-model="checkboxList" placeholder="可多選" multiple>
					<el-option v-for="item in 9" :key="item" :value="item - 1 + fullYear" :label="item -1 + fullYear" />
				</el-select>
			</el-radio>
		</el-form-item>
	</el-form>
</template>

<script>
export default {
	data() {
		return {
			fullYear: 0,
			radioValue: 1,
			cycle01: 0,
			cycle02: 0,
			average01: 0,
			average02: 1,
			checkboxList: [],
			checkNum: this.$options.propsData.check
		}
	},
	name: 'crontab-year',
	props: ['check', 'month', 'cron'],
	methods: {
		// 單選按鈕值變化時
		radioChange() {
			switch (this.radioValue) {
				case 1:
					this.$emit('update', 'year', '')
					break
				case 2:
					this.$emit('update', 'year', '*')
					break
				case 3:
					this.$emit('update', 'year', this.cycleTotal)
					break
				case 4:
					this.$emit('update', 'year', this.averageTotal)
					break
				case 5:
					this.$emit('update', 'year', this.checkboxString)
					break
			}
		},
		// 週期兩個值變化時
		cycleChange() {
			if (this.radioValue == '3') {
				this.$emit('update', 'year', this.cycleTotal)
			}
		},
		// 平均兩個值變化時
		averageChange() {
			if (this.radioValue == '4') {
				this.$emit('update', 'year', this.averageTotal)
			}
		},
		// checkbox值變化時
		checkboxChange() {
			if (this.radioValue == '5') {
				this.$emit('update', 'year', this.checkboxString)
			}
		}
	},
	watch: {
		'radioValue': 'radioChange',
		'cycleTotal': 'cycleChange',
		'averageTotal': 'averageChange',
		'checkboxString': 'checkboxChange'
	},
	computed: {
		// 計算兩個週期值
		cycleTotal: function () {
			const cycle01 = this.checkNum(this.cycle01, this.fullYear, 2098)
			const cycle02 = this.checkNum(this.cycle02, cycle01 ? cycle01 + 1 : this.fullYear + 1, 2099)
			return cycle01 + '-' + cycle02
		},
		// 計算平均用到的值
		averageTotal: function () {
			const average01 = this.checkNum(this.average01, this.fullYear, 2098)
			const average02 = this.checkNum(this.average02, 1, 2099 - average01 || this.fullYear)
			return average01 + '/' + average02
		},
		// 計算勾選的checkbox值合集
		checkboxString: function () {
			let str = this.checkboxList.join()
			return str
		}
	},
	mounted: function () {
		// 僅獲取當前年份
		this.fullYear = Number(new Date().getFullYear())
		this.cycle01 = this.fullYear
		this.average01 = this.fullYear
	}
}
</script>
