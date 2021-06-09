package main

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import json.Query
import json.QueryConfig
import json.QueryContainer
import json.SpecificationTask
import json.Specifications
import json.Tag
import json.TaskType
import json.Term
import json.VBSCategories
import json.VBSTypes
import java.util.*

/*
* This class is used for a more adaptive way to build the specification files used for the evaluation.
*
* We can easily build our own specifications from the task pool.
*/
class SpecsBuilder {
    private val gson: Gson = Gson()
    private val tasks = ArrayList<SpecificationTask>()

    fun buildSpecs(): Specifications {
        buildFromPoolVisualCoEmbeding(PoolTask1())
        buildFromPoolVisualCoEmbeding(PoolTask2())
        buildFromPoolVisualCoEmbeding(PoolTask3())
        buildFromPoolVisualCoEmbeding(PoolTask4())
        buildFromPoolVisualCoEmbeding(PoolTask5())
        buildFromPoolVisualCoEmbeding(PoolTask6())
        buildFromPoolVisualCoEmbeding(PoolTask7())
        buildFromPoolVisualCoEmbeding(PoolTask8())
        buildFromPoolVisualCoEmbeding(PoolTask9())
        buildFromPoolVisualCoEmbeding(PoolTask10())
        buildFromPoolVisualCoEmbeding(PoolTask11())
        buildFromPoolVisualCoEmbeding(PoolTask12())
        buildFromPoolVisualCoEmbeding(PoolTask13())
        buildFromPoolVisualCoEmbeding(PoolTask14())
        buildFromPoolVisualCoEmbeding(PoolTask15())
        buildFromPoolVisualCoEmbeding(PoolTask16())
        buildFromPoolVisualCoEmbeding(PoolTask17())
        buildFromPoolVisualCoEmbeding(PoolTask18())
        buildFromPoolVisualCoEmbeding(PoolTask19())
        buildFromPoolVisualCoEmbeding(PoolTask20())
        buildFromPoolVisualCoEmbeding(PoolTask21())
        buildFromPoolVisualCoEmbeding(PoolTask22())
        buildFromPoolVisualCoEmbeding(PoolTask23())
        buildFromPoolVisualCoEmbeding(PoolTask24())
        buildFromPoolVisualCoEmbeding(PoolTask25())
        buildFromPool(PoolTask1())
        buildFromPool(PoolTask2())
        buildFromPool(PoolTask3())
        buildFromPool(PoolTask4())
        buildFromPool(PoolTask5())
        buildFromPool(PoolTask6())
        buildFromPool(PoolTask7())
        buildFromPool(PoolTask8())
        buildFromPool(PoolTask9())
        buildFromPool(PoolTask10())
        buildFromPool(PoolTask11())
        buildFromPool(PoolTask12())
        buildFromPool(PoolTask13())
        buildFromPool(PoolTask14())
        buildFromPool(PoolTask15())
        buildFromPool(PoolTask16())
        buildFromPool(PoolTask17())
        buildFromPool(PoolTask18())
        buildFromPool(PoolTask19())
        buildFromPool(PoolTask20())
        buildFromPool(PoolTask21())
        buildFromPool(PoolTask22())
        buildFromPool(PoolTask23())
        buildFromPool(PoolTask24())
        buildFromPool(PoolTask25())

//        buildFromLargePool(LargePoolTask1())
//        buildFromLargePool(LargePoolTask2())
//        buildFromLargePool(LargePoolTask3())

        return Specifications(
            tasks
        )
    }

    fun buildFromPool(pool: Pool) {
        var i = 1

        addZeroQueries(pool, i++, pool.query1)
        addZeroQueries(pool, i++, pool.query2)
        addZeroQueries(pool, i++, pool.query3)
        addZeroQueries(pool, i++, pool.query4)

        addOneQueries(pool, i++, pool.query1, pool.query2)
        addOneQueries(pool, i++, pool.query1, pool.query3)
        addOneQueries(pool, i++, pool.query1, pool.query4)
        addOneQueries(pool, i++, pool.query2, pool.query3)
        addOneQueries(pool, i++, pool.query2, pool.query4)
        addOneQueries(pool, i++, pool.query3, pool.query4)

        addTwoQueries(pool, i++, pool.query1, pool.query2, pool.query3)
        addTwoQueries(pool, i++, pool.query1, pool.query2, pool.query4)
        addTwoQueries(pool, i++, pool.query1, pool.query3, pool.query4)
        addTwoQueries(pool, i++, pool.query2, pool.query3, pool.query4)

        addThreeQueries(pool, i, pool.query1, pool.query2, pool.query3, pool.query4)
    }

    fun buildFromPoolVisualCoEmbeding(pool: Pool) {
        var i = 1

        addZeroQueries(pool, i++, transformToVisualCoEmbeding(pool.query1))
        addZeroQueries(pool, i++, transformToVisualCoEmbeding(pool.query2))
        addZeroQueries(pool, i++, transformToVisualCoEmbeding(pool.query3))
        addZeroQueries(pool, i++, transformToVisualCoEmbeding(pool.query4))

        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query1), transformToVisualCoEmbeding(pool.query2))
        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query1), transformToVisualCoEmbeding(pool.query3))
        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query1), transformToVisualCoEmbeding(pool.query4))
        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query2), transformToVisualCoEmbeding(pool.query3))
        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query2), transformToVisualCoEmbeding(pool.query4))
        addOneQueries(pool, i++, transformToVisualCoEmbeding(pool.query3), transformToVisualCoEmbeding(pool.query4))

        addTwoQueries(
            pool,
            i++,
            transformToVisualCoEmbeding(pool.query1),
            transformToVisualCoEmbeding(pool.query2),
            transformToVisualCoEmbeding(pool.query3)
        )
        addTwoQueries(
            pool,
            i++,
            transformToVisualCoEmbeding(pool.query1),
            transformToVisualCoEmbeding(pool.query2),
            transformToVisualCoEmbeding(pool.query4)
        )
        addTwoQueries(
            pool,
            i++,
            transformToVisualCoEmbeding(pool.query1),
            transformToVisualCoEmbeding(pool.query3),
            transformToVisualCoEmbeding(pool.query4)
        )
        addTwoQueries(
            pool,
            i++,
            transformToVisualCoEmbeding(pool.query2),
            transformToVisualCoEmbeding(pool.query3),
            transformToVisualCoEmbeding(pool.query4)
        )

        addThreeQueries(
            pool,
            i,
            transformToVisualCoEmbeding(pool.query1),
            transformToVisualCoEmbeding(pool.query2),
            transformToVisualCoEmbeding(pool.query3),
            transformToVisualCoEmbeding(pool.query4)
        )
    }

    fun transformToVisualCoEmbeding(query: Query): Query {

        val list = arrayListOf<Term>()
        query.containers.forEach {
            it.terms.forEach { term ->
                var localTerm: Term
                if (term.type.first() == VBSTypes.concept) {
                    val tmpString = term.data.split(",")[1]
                    val decodedBytes = Base64.getDecoder().decode(tmpString)
                    val decodedData = String(decodedBytes)
                    var tags: List<Tag> = listOf()
                    try {
                        val listTagType = object : TypeToken<List<Tag>>() {}.type
                        tags = gson.fromJson(decodedData, listTagType)
                    } catch (e: JsonSyntaxException) {
                    }
                    var s = ""
                    tags.forEach { tag ->
                        s += tag.name
                        s += " "
                    }
                    localTerm = Term(VBSCategories.text, listOf(VBSTypes.visualtextcoembedding), s)
                } else {
                    localTerm = term
                }
                list.add(localTerm)
            }
        }
        return Query(listOf(QueryContainer(list)))
    }

    fun addZeroQueries(pool: Pool, i: Int, query: Query) {
        val qId = i.toString().padStart(2, '0')
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query),
                QueryConfig("3584f2e1-e562-4e4c-bf25-809c9f${pool.poolId}${qId}00"), // db8cca41-b7ee-4032-a6d7-809c9f77b2e8
                listOf()
            )
        )
    }

    fun addOneQueries(pool: Pool, i: Int, query1: Query, query2: Query) {
        val qId = i.toString().padStart(2, '0')
        var t = 0
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d001"),
                listOf(3)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d001"),
                listOf(6)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d001"),
                listOf(9)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d001"),
                listOf(12)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d001"),
                listOf(15)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t}8d001"),
                listOf(18)
            )
        )
    }

    fun addTwoQueries(pool: Pool, i: Int, query1: Query, query2: Query, query3: Query) {
        val qId = i.toString().padStart(2, '0')
        var t = 0
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(3, 3)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(3, 6)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(6, 3)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(6, 6)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(9, 6)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(6, 9)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(9, 9)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(12, 9)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t++}8d002"),
                listOf(9, 12)
            )
        )
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${t}8d002"),
                listOf(12, 12)
            )
        )
    }

    fun addThreeQueries(pool: Pool, i: Int, query1: Query, query2: Query, query3: Query, query4: Query) {
        val qId = i.toString().padStart(2, '0')
        var t = 0
        var tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 3, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 6, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 6, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 3, 6)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 6, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 6, 6, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 6, 6)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 3, 6, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 3, 3, 6)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 6, 3, 6)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 3, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 9, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 9, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 3, 9)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 9, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 3, 9, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 3, 3, 9)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 9, 9, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 3, 9, 9)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 9, 3, 9)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 6, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 3, 6, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(9, 3, 3, 6)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 9, 3, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 3, 9, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(6, 3, 3, 9)
            )
        )
        tId = t.toString().padStart(2, '0')
        t++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 6, 9, 3)
            )
        )
        tId = t.toString().padStart(2, '0')
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                pool.result,
                listOf(query1, query2, query3, query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${pool.poolId}${qId}${tId}d003"),
                listOf(3, 9, 6, 3)
            )
        )
    }

    fun buildFromLargePool(largePool: LargePool) {
        var i = 1

        var qId = i.toString().padStart(2, '0')
        var t = 0
        var tId = t.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d000"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d000"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d000"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d000"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query2, largePool.query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query2, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query3, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d001"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query3),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d002"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d002"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query3, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d002"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query2, largePool.query3, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d002"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query3, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d003"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query3, largePool.query4),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d003"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query3, largePool.query4, largePool.query5),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d04"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d005"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query7
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d006"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query7,
                    largePool.query8
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d007"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query7,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d008"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d008"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query5,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d007"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d006"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d005"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query5, largePool.query6, largePool.query5, largePool.query8, largePool.query9),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d004"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(largePool.query1, largePool.query2, largePool.query3, largePool.query4, largePool.query5),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d004"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query3,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d005"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d006"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        t++
        i++
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query4,
                    largePool.query5,
                    largePool.query6,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d007"),
                listOf()
            )
        )
        tId = t.toString().padStart(2, '0')
        qId = i.toString().padStart(2, '0')
        tasks.add(
            SpecificationTask(
                "",
                TaskType.KIST,
                largePool.result,
                listOf(
                    largePool.query1,
                    largePool.query2,
                    largePool.query4,
                    largePool.query3,
                    largePool.query5,
                    largePool.query1,
                    largePool.query5,
                    largePool.query8,
                    largePool.query9
                ),
                QueryConfig("3584f2e1-e562-4e4c-bf25-80${largePool.poolId}${qId}${tId}d008"),
                listOf()
            )
        )
    }

}
