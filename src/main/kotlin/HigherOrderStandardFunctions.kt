class Team {
    var teamName: String? = null
    var teamEstablishmentDate: Int = 2019

    fun validateDate(date: Int) =
        if (date in 1..2019) teamEstablishmentDate = date else teamEstablishmentDate = 2019

    fun printTeamData() = println("Team Name : $teamName And Establishment Date : $teamEstablishmentDate")
}

fun String.printData() = println(this)
fun main() {
    val teamOne = Team().also {
        it.teamName = "MU"
        it.teamEstablishmentDate = 1990
    }
    val teamTwo = Team().apply {
        teamName = "LFC"
        teamEstablishmentDate = 1892
    }
    with(teamTwo) {
        println(teamName)
        println(teamEstablishmentDate)
    }

}

private fun runWithoutReciver(teamOne: Team, teamTwo: Team) {
    run {
        if (teamOne.teamEstablishmentDate > teamTwo.teamEstablishmentDate) teamOne else teamOne
    }.printTeamData()
}

private fun unresolvedReferenceLet(teamOne: Team, teamTwo: Team) {
//    let {
//        if (teamOne.teamEstablishmentDate > teamTwo.teamEstablishmentDate) teamOne else teamOne
//    }.printTeamData()
}

fun getFavTeamNotNull(): Team? {
    return Team()
}

fun getFavTeam(): Team? {
    //get team from api and for some reasons team is null
    return null
}

private fun letExampleConvertFromTypeToAnother() {
    val team: Team? = getFavTeamNotNull()
    team?.let { myTeam ->
        myTeam.teamName = "Liverpool"
        myTeam.teamEstablishmentDate = 1892
        "Team Name : ${myTeam.teamName} And Establishment Date : ${myTeam.teamEstablishmentDate}"
    }?.printData()//it will  execute because team is not null
}

private fun runExampleConvertFromTypeToAnother() {
    val team: Team? = getFavTeamNotNull()
    team?.run {
        teamName = "Liverpool"
        teamEstablishmentDate = 1892
        "Team Name : ${teamName} And Establishment Date : ${teamEstablishmentDate}"
    }?.printData()//it will  execute because team is not null
}

private fun letExample() {
    val team: Team? = getFavTeamNotNull()
    team?.let { myTeam ->
        myTeam.teamName = "I love Liverpool"
        myTeam.teamEstablishmentDate = 1892
        myTeam //here i returned the same object
    }?.printTeamData()//it will  execute because team is not null
}

private fun runExample() {
    val team: Team? = getFavTeamNotNull()
    team?.run {
        teamName = "I love Liverpool"
        teamEstablishmentDate = 1892
        this //here i returned the same object
    }?.printTeamData()//it will  execute because team is not null
}

private fun letExampleHandlingNullability() {
    val team: Team? = getFavTeam()
    team?.let { myTeam ->
        myTeam.teamName = "I love Liverpool"
        myTeam.teamEstablishmentDate = 1892
        myTeam //here i returned the same object
    }?.printTeamData()//it will never execute because team is null
}

private fun runExampleHandlingNullability() {
    val team: Team? = getFavTeam()
    team?.run {
        teamName = "I love Liverpool"
        teamEstablishmentDate = 1892
        this //here i returned the same object
    }?.printTeamData()//it will never execute because team is null
}

private fun notWorkingApply() {
//    Team().apply { team ->
//        teamName = "Liverpool"
//        teamEstablishmentDate = 1892
//    }.printTeamData()
}

private fun applyFunctionExample() {
    Team().apply {
        teamName = "Liverpool"
        teamEstablishmentDate = 1892
    }.printTeamData()
}

private fun alsoFunctionExample() {
    Team().also {
        it.teamName = "Liverpool"
        it.teamEstablishmentDate = 1892
    }.printTeamData()

    Team().also {
        it.teamName = "Liverpool"
        it.validateDate(18920)
    }.printTeamData()
}

private fun renamingArgumentUsingAlso() {
    Team().also { team ->
        team.teamName = "Liverpool"
        team.teamEstablishmentDate = 1892
    }.printTeamData()
}