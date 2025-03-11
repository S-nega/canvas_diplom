package kz.narxoz.canvasdiplom

import kz.narxoz.canvasdiplom.data.LocalTasksDataProvider
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kz.narxoz.canvasdiplom.models.Task

@HiltViewModel
class TasksViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(
        TasksUiState(
            tasksList = emptyList(),
            currentTask = null
        )
    )
    val uiState: StateFlow<TasksUiState> = _uiState

    fun fetchTasksData(context: Context) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                // Загружаем данные из памяти
//                val tasksList = LocalTasksDataProvider.loadTasksFromPreferences(context)
//                    ?: LocalTasksDataProvider.getStaticTasksData().also {
//                         Если данных нет, используем статичные и сохраняем их в память
//                        LocalTasksDataProvider.saveTasksToPreferences(context, it)
//                    }

                currentState.copy(
//                    tasksList = tasksList,
                    currentTask = LocalTasksDataProvider.staticTasksData[0]
                )
            }
        }
    }

    // Функция для обновления текущего выбранного
    fun updateCurrentTask(selectedTask: Task) {
        _uiState.update {
            it.copy(currentTask = selectedTask)
        }
    }

    // Функция для перехода на страницу списка видов спорта
    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true, isShowingAddPage = false)
        }
    }

    // Функция для перехода на страницу добавления нового спорта
    fun navigateToAddPage() {
        _uiState.update {
            it.copy(isShowingListPage = false, isShowingAddPage = true)
        }
    }

//    fun addTask(context: Context, task: Task) {
//        val updatedList = _uiState.value.tasksList + task
//        _uiState.update { it.copy(taskList = updatedList) }
//        LocalTasksDataProvider.saveTasksToPreferences(context, updatedList)
//    }

    // Функция для перехода на страницу подробностей
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

annotation class Inject

annotation class HiltViewModel

data class TasksUiState(
    val tasksList: List<Task> = emptyList(),
    val currentTask: Task? = null,
    val isShowingListPage: Boolean = true,
    val isShowingAddPage: Boolean = false
)