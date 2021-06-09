package main

import json.Query
import json.QueryContainer
import json.Result
import json.Term
import json.VBSCategories
import json.VBSTypes

/*
* This file contains classes that are tasks that can be evaluated and built to be part of a specification in the SpecsBuilder.
*/

abstract class Pool {
    abstract val poolId: String
    abstract val result: Result
    abstract val query1: Query
    abstract val query2: Query
    abstract val query3: Query
    abstract val query4: Query
}

data class PoolTask1(
    override val poolId: String = "01",
    override val result: Result = Result("v_07017", 95f, 115f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTIyODAiLCJuYW1lIjoiYnJpZGdlIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUgYnVpbHQgdG8gc3BhbiBwaHlzaWNhbCBvYnN0YWNsZXMifSx7ImlkIjoiUTE3NTMzNCIsIm5hbWUiOiJ3aGVlbGJhcnJvdyIsImRlc2NyaXB0aW9uIjoic21hbGwgaGFuZC1wcm9wZWxsZWQgdmVoaWNsZSJ9XQ=="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "middle"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTIzMzMyMCIsIm5hbWUiOiJzY2FmZm9sZCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IHN0cnVjdHVyZSB1c2VkIHRvIHN1cHBvcnQgYSB3b3JrIGNyZXcgYW5kIG1hdGVyaWFscyJ9LHsiaWQiOiJRNDIzMDIiLCJuYW1lIjoiY2xheSIsImRlc2NyaXB0aW9uIjoic29mdCByb2NrIGJhc2VkIGNvbXBvdW5kIG9mdGVuIHVzZWQgZm9yIHNjdWxwdHVyZSBhbmQgdG9vbHMifV0="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "reconstructed"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTQ5NzM2NCIsIm5hbWUiOiJidWlsZGluZyBjb21wbGV4IiwiZGVzY3JpcHRpb24iOiJzZXQgb2YgcmVsYXRlZCBidWlsZGluZ3MifSx7ImlkIjoiUTQxMTc2IiwibmFtZSI6ImJ1aWxkaW5nIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUsIHR5cGljYWxseSB3aXRoIGEgcm9vZiBhbmQgd2FsbHMsIHN0YW5kaW5nIG1vcmUgb3IgbGVzcyBwZXJtYW5lbnRseSBpbiBvbmUgcGxhY2UifSx7ImlkIjoiUTIzMzMyMCIsIm5hbWUiOiJzY2FmZm9sZCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IHN0cnVjdHVyZSB1c2VkIHRvIHN1cHBvcnQgYSB3b3JrIGNyZXcgYW5kIG1hdGVyaWFscyJ9LHsiaWQiOiJRMTY1MzIyNzYiLCJuYW1lIjoid29yayIsImRlc2NyaXB0aW9uIjoiYWN0aXZpdHkgZG9uZSBieSBhIHBlcnNvbiB0byBlYXJuIGEgbGl2aW5nIn0seyJpZCI6IlEzODc1MTg2IiwibmFtZSI6ImNvbnN0cnVjdGlvbiIsImRlc2NyaXB0aW9uIjoicHJvY2VzcyBvZiBidWlsZGluZyJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzcwMTciLCJuYW1lIjoiZmFjZSIsImRlc2NyaXB0aW9uIjoicGFydCBvZiB0aGUgYm9keSBhdCB0aGUgZnJvbnQgb2YgdGhlIGhlYWQifV0="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "by traditional material"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask2(
    override val poolId: String = "02",
    override val result: Result = Result("v_04355", 74f, 92f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTA1Njc0IiwibmFtZSI6InJ1bm5pbmciLCJkZXNjcmlwdGlvbiI6Im1ldGhvZCBvZiB0ZXJyZXN0cmlhbCBsb2NvbW90aW9uIGFsbG93aW5nIGh1bWFucyBhbmQgb3RoZXIgYW5pbWFscyB0byBtb3ZlIHJhcGlkbHkgb24gZm9vdCJ9LHsiaWQiOiJRNDAwODAiLCJuYW1lIjoiYmVhY2giLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2Ygc2FuZCBvciBzbWFsbCBzdG9uZXMgbmVhciB0aGUgc2VhIG9yIGFub3RoZXIgYXJlYSBvZiB3YXRlciBzdWNoIGFzIGEgbGFrZSJ9LHsiaWQiOiJRMTY4ODczODAiLCJuYW1lIjoiZ3JvdXAiLCJkZXNjcmlwdGlvbiI6InN1bW1hcml6ZXMgZW50aXRpZXMgd2l0aCBzaW1pbGFyIGNoYXJhY3RlcmlzdGljcyB0b2dldGhlciJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDU3Njg5IiwibmFtZSI6InN1cmZib2FyZCIsImRlc2NyaXB0aW9uIjoiZWxvbmdhdGVkIHBsYXRmb3JtIHVzZWQgaW4gdGhlIHNwb3J0IG9mIHN1cmZpbmcifSx7ImlkIjoiUTQwMDgwIiwibmFtZSI6ImJlYWNoIiwiZGVzY3JpcHRpb24iOiJhcmVhIG9mIHNhbmQgb3Igc21hbGwgc3RvbmVzIG5lYXIgdGhlIHNlYSBvciBhbm90aGVyIGFyZWEgb2Ygd2F0ZXIgc3VjaCBhcyBhIGxha2UifSx7ImlkIjoiUTEwMzU0NzgzIiwibmFtZSI6InByYWN0aWNlIiwiZGVzY3JpcHRpb24iOiJtYW5pZmVzdGluZyB0aGVvcnkgaW50byBwaHlzaWNhbCBhY3Rpb24ifSx7ImlkIjoiUTM3MjI2IiwibmFtZSI6InRlYWNoZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiB3aG8gaGVscHMgb3RoZXJzIHRvIGFjcXVpcmUga25vd2xlZGdlLCBjb21wZXRlbmNlcyBvciB2YWx1ZXMifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTYzNTg2MTAiLCJuYW1lIjoiaW5zdHJ1Y3RvciIsImRlc2NyaXB0aW9uIjoicGVyc29uIHdobyB0ZWFjaGVzIG90aGVycyJ9LHsiaWQiOiJRMTk4NjA5OCIsIm5hbWUiOiJzdGFuZGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcG9zaXRpb24gaW4gd2hpY2ggdGhlIGJvZHkgaXMgaGVsZCBpbiBhbiB1cHJpZ2h0IHBvc2l0aW9uIn0seyJpZCI6IlExMzQ1MDI4MyIsIm5hbWUiOiJ3ZXRzdWl0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB3YXRlciBhY3Rpdml0aWVzLCBwcm92aWRpbmcgdGhlcm1hbCBpbnN1bGF0aW9uIGJ1dCBub3QgZGVzaWduZWQgdG8gcHJldmVudCB3YXRlciBlbnRlcmluZyJ9LHsiaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE2ODg3MzgwIiwibmFtZSI6Imdyb3VwIiwiZGVzY3JpcHRpb24iOiJzdW1tYXJpemVzIGVudGl0aWVzIHdpdGggc2ltaWxhciBjaGFyYWN0ZXJpc3RpY3MgdG9nZXRoZXIifSx7ImlkIjoiUTM3OTgzMyIsIm5hbWUiOiJsZXNzb24iLCJkZXNjcmlwdGlvbiI6InNlY3Rpb24gb2YgbGVhcm5pbmcgb3IgdGVhY2hpbmcgaW50byB3aGljaCBhIHdpZGVyIGxlYXJuaW5nIGNvbnRlbnQgaXMgZGl2aWRlZCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTU5OTkyIiwibmFtZSI6InN1cmZpbmciLCJkZXNjcmlwdGlvbiI6InNwb3J0IHRoYXQgY29uc2lzdHMgb2YgcmlkaW5nIGEgd2F2ZSJ9LHsiaWQiOiJRNDAwODAiLCJuYW1lIjoiYmVhY2giLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2Ygc2FuZCBvciBzbWFsbCBzdG9uZXMgbmVhciB0aGUgc2VhIG9yIGFub3RoZXIgYXJlYSBvZiB3YXRlciBzdWNoIGFzIGEgbGFrZSJ9LHsiaWQiOiJRMTk4NjA5OCIsIm5hbWUiOiJzdGFuZGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcG9zaXRpb24gaW4gd2hpY2ggdGhlIGJvZHkgaXMgaGVsZCBpbiBhbiB1cHJpZ2h0IHBvc2l0aW9uIn1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask3(
    override val poolId: String = "03",
    override val result: Result = Result("v_07119", 98f, 118f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTQwIiwibmFtZSI6Imxpb24iLCJkZXNjcmlwdGlvbiI6InNwZWNpZXMgb2YgYmlnIGNhdCJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTUwODMiLCJuYW1lIjoibm9ydGhlcm4gZ2lyYWZmZSIsImRlc2NyaXB0aW9uIjoicHJvcG9zZWQgc3BlY2llcyBvZiBnaXJhZmZlIG5hdGl2ZSB0byBOb3J0aCBBZnJpY2EifSx7ImlkIjoiUTIxMzQ0OSIsIm5hbWUiOiJlYXRpbmciLCJkZXNjcmlwdGlvbiI6ImluZ2VzdGlvbiBvZiBmb29kIHRvIHByb3ZpZGUgZm9yIGFsbCBvcmdhbmlzbXMgdGhlaXIgbnV0cml0aW9uYWwgb3IgbWVkaWNpbmFsIG5lZWRzIn0seyJpZCI6IlExMDg4NCIsIm5hbWUiOiJ0cmVlIiwiZGVzY3JpcHRpb24iOiJwZXJlbm5pYWwgd29vZHkgcGxhbnQifSx7ImlkIjoiUTk2MTQiLCJuYW1lIjoidG9uZ3VlIiwiZGVzY3JpcHRpb24iOiJtb2JpbGUgb3JnYW4gbG9jYXRlZCBpbnNpZGUgdGhlIG1vdXRoIn0seyJpZCI6IlE1MjciLCJuYW1lIjoic2t5IiwiZGVzY3JpcHRpb24iOiJldmVyeXRoaW5nIHRoYXQgaXMgYWJvdmUgdGhlIHN1cmZhY2Ugb2YgdGhlIEVhcnRoIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTUwODMiLCJuYW1lIjoibm9ydGhlcm4gZ2lyYWZmZSIsImRlc2NyaXB0aW9uIjoicHJvcG9zZWQgc3BlY2llcyBvZiBnaXJhZmZlIG5hdGl2ZSB0byBOb3J0aCBBZnJpY2EifSx7ImlkIjoiUTY1MzczNzkiLCJuYW1lIjoid2Fsa2luZyIsImRlc2NyaXB0aW9uIjoib25lIG9mIHRoZSBtYWluIGdhaXRzIG9mIGxvY29tb3Rpb24gYW1vbmcgbGVnZ2VkIGFuaW1hbHMsIHR5cGljYWxseSBzbG93ZXIgdGhhbiBydW5uaW5nIGFuZCBvdGhlciBnYWl0czsgY2hhcmFjdGVyaXplZCBieSBhICd2YXVsdGluZycgbW92ZW1lbnQgb2YgdGhlIGJvZHkgb3ZlciB0aGUgbGVncywgZnJlcXVlbnRseSBkZXNjcmliZWQgYXMgYW4gaW52ZXJ0ZWQgcGVuZHVsdW0ifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzM3OCIsIm5hbWUiOiJlbGVwaGFudCIsImRlc2NyaXB0aW9uIjoidHJ1bmstYmVhcmluZyBsYXJnZSBtYW1tYWwifSx7ImlkIjoiUTI4MyIsIm5hbWUiOiJ3YXRlciIsImRlc2NyaXB0aW9uIjoiY2hlbWljYWwgY29tcG91bmQ7IG1haW4gY29uc3RpdHVlbnQgb2YgdGhlIGZsdWlkcyBvZiBtb3N0IGxpdmluZyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask4(
    override val poolId: String = "04",
    override val result: Result = Result("v_02123", 38f, 59f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjgzIiwibmFtZSI6IndhdGVyIiwiZGVzY3JpcHRpb24iOiJjaGVtaWNhbCBjb21wb3VuZDsgbWFpbiBjb25zdGl0dWVudCBvZiB0aGUgZmx1aWRzIG9mIG1vc3QgbGl2aW5nIG9yZ2FuaXNtcyJ9LHsiaWQiOiJRNTExMyIsIm5hbWUiOiJiaXJkIiwiZGVzY3JpcHRpb24iOiJjbGFzcyBvZiB0ZXRyYXBvZHMifSx7ImlkIjoiUTIxNTYyNyIsIm5hbWUiOiJwZXJzb24iLCJkZXNjcmlwdGlvbiI6ImJlaW5nIHRoYXQgaGFzIGNlcnRhaW4gY2FwYWNpdGllcyBvciBhdHRyaWJ1dGVzIGNvbnN0aXR1dGluZyBwZXJzb25ob29kIChhdm9pZCB1c2Ugd2l0aCBQMzE7IHVzZSBRNSBmb3IgaHVtYW5zKSJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTExMyIsIm5hbWUiOiJiaXJkIiwiZGVzY3JpcHRpb24iOiJjbGFzcyBvZiB0ZXRyYXBvZHMifSx7ImlkIjoiUTI4MyIsIm5hbWUiOiJ3YXRlciIsImRlc2NyaXB0aW9uIjoiY2hlbWljYWwgY29tcG91bmQ7IG1haW4gY29uc3RpdHVlbnQgb2YgdGhlIGZsdWlkcyBvZiBtb3N0IGxpdmluZyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTcxIiwibmFtZSI6ImJvb2siLCJkZXNjcmlwdGlvbiI6Im1lZGl1bSBmb3IgcmVjb3JkaW5nIGluZm9ybWF0aW9uIGluIHRoZSBmb3JtIG9mIHdyaXRpbmcgb3IgaW1hZ2VzIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTI1MTQwMyIsIm5hbWUiOiJhbGxleSIsImRlc2NyaXB0aW9uIjoibmFycm93IHN0cmVldCJ9LHsiaWQiOiJRNjUzNzM3OSIsIm5hbWUiOiJ3YWxraW5nIiwiZGVzY3JpcHRpb24iOiJvbmUgb2YgdGhlIG1haW4gZ2FpdHMgb2YgbG9jb21vdGlvbiBhbW9uZyBsZWdnZWQgYW5pbWFscywgdHlwaWNhbGx5IHNsb3dlciB0aGFuIHJ1bm5pbmcgYW5kIG90aGVyIGdhaXRzOyBjaGFyYWN0ZXJpemVkIGJ5IGEgJ3ZhdWx0aW5nJyBtb3ZlbWVudCBvZiB0aGUgYm9keSBvdmVyIHRoZSBsZWdzLCBmcmVxdWVudGx5IGRlc2NyaWJlZCBhcyBhbiBpbnZlcnRlZCBwZW5kdWx1bSJ9LHsiaWQiOiJRMjE1NjI3IiwibmFtZSI6InBlcnNvbiIsImRlc2NyaXB0aW9uIjoiYmVpbmcgdGhhdCBoYXMgY2VydGFpbiBjYXBhY2l0aWVzIG9yIGF0dHJpYnV0ZXMgY29uc3RpdHV0aW5nIHBlcnNvbmhvb2QgKGF2b2lkIHVzZSB3aXRoIFAzMTsgdXNlIFE1IGZvciBodW1hbnMpIn1d"
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "I follow him through the streets,"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask5(
    override val poolId: String = "05",
    override val result: Result = Result("v_06824", 8f, 25f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDAwODAiLCJuYW1lIjoiYmVhY2giLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2Ygc2FuZCBvciBzbWFsbCBzdG9uZXMgbmVhciB0aGUgc2VhIG9yIGFub3RoZXIgYXJlYSBvZiB3YXRlciBzdWNoIGFzIGEgbGFrZSJ9LHsiaWQiOiJRNDExNzYiLCJuYW1lIjoiYnVpbGRpbmciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZSwgdHlwaWNhbGx5IHdpdGggYSByb29mIGFuZCB3YWxscywgc3RhbmRpbmcgbW9yZSBvciBsZXNzIHBlcm1hbmVudGx5IGluIG9uZSBwbGFjZSJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNjE0ODA2IiwibmFtZSI6InN1aXQiLCJkZXNjcmlwdGlvbiI6InNldCBvZiBtYXRjaGluZyBnYXJtZW50cyB1c2VkIGFzIGZvcm1hbCBvciBidXNpbmVzcyBhdHRpcmUifSx7ImlkIjoiUTg0NDEiLCJuYW1lIjoibWFuIiwiZGVzY3JpcHRpb24iOiJtYWxlIGFkdWx0IGh1bWFuIn0seyJpZCI6IlE0NjM4NCIsIm5hbWUiOiJtaWNyb3Bob25lIiwiZGVzY3JpcHRpb24iOiJhY291c3RpYy10by1lbGVjdHJpYyB0cmFuc2R1Y2VyIG9yIHNlbnNvciB0aGF0IGNvbnZlcnRzIHNvdW5kIGludG8gYW4gZWxlY3RyaWNhbCBzaWduYWwifSx7ImlkIjoiUTM3NTAxIiwibmFtZSI6ImV5ZWdsYXNzZXMiLCJkZXNjcmlwdGlvbiI6ImFjY2Vzc29yaWVzIHRoYXQgaW1wcm92ZSBodW1hbiB2aXNpb24ifSx7ImlkIjoiUTQ5ODM2IiwibmFtZSI6IndlZGRpbmciLCJkZXNjcmlwdGlvbiI6ImNlcmVtb255IHdoZXJlIHBlb3BsZSBhcmUgdW5pdGVkIGluIG1hcnJpYWdlIn0seyJpZCI6IlE1MDYiLCJuYW1lIjoiZmxvd2VyIiwiZGVzY3JpcHRpb24iOiJzZXh1YWwgcmVwcm9kdWN0aXZlIHN0cnVjdHVyZSBmb3VuZCBpbiBmbG93ZXJpbmcgcGxhbnRzIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDk4MzYiLCJuYW1lIjoid2VkZGluZyIsImRlc2NyaXB0aW9uIjoiY2VyZW1vbnkgd2hlcmUgcGVvcGxlIGFyZSB1bml0ZWQgaW4gbWFycmlhZ2UifSx7ImlkIjoiUTE0MjU0NDgiLCJuYW1lIjoiZ3Jvb21zbWFuIiwiZGVzY3JpcHRpb24iOiJtZW1iZXIgb2YgdGhlIGdyb29tJ3MgcGFydHkgaW4gYSB3ZWRkaW5nIn0seyJpZCI6IlEzNTM2NzMiLCJuYW1lIjoiYnJpZGUiLCJkZXNjcmlwdGlvbiI6IndvbWFuIHdobyBpcyBhYm91dCB0byBiZSBtYXJyaWVkIG9yIHdobyBpcyBuZXdseXdlZCB0byBhIG1hbiBvciB3b21hbiJ9LHsiaWQiOiJRNDYzODQiLCJuYW1lIjoibWljcm9waG9uZSIsImRlc2NyaXB0aW9uIjoiYWNvdXN0aWMtdG8tZWxlY3RyaWMgdHJhbnNkdWNlciBvciBzZW5zb3IgdGhhdCBjb252ZXJ0cyBzb3VuZCBpbnRvIGFuIGVsZWN0cmljYWwgc2lnbmFsIn0seyJpZCI6IlE1OTk0IiwibmFtZSI6InBpYW5vIiwiZGVzY3JpcHRpb24iOiJtdXNpY2FsIGluc3RydW1lbnQifSx7ImlkIjoiUTgzNzEiLCJuYW1lIjoiY2VsbG8iLCJkZXNjcmlwdGlvbiI6Im11c2ljYWwgaW5zdHJ1bWVudCJ9LHsiaWQiOiJRNjM4IiwibmFtZSI6Im11c2ljIiwiZGVzY3JpcHRpb24iOiJmb3JtIG9mIGFydCB1c2luZyBzb3VuZCBzcGVjaWZpY2FsbHkifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTE4MTk0NCIsIm5hbWUiOiJjZWlsaW5nIGZhbiIsImRlc2NyaXB0aW9uIjoidHlwZSBvZiBmYW4gYXBwbGlhbmNlIHBlcm1hbmVudGx5IG1vdW50ZWQgdG8gdGhlIGNlaWxpbmcgaG9yaXpvbnRhbGx5In1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask6(
    override val poolId: String = "06",
    override val result: Result = Result("v_04938", 223f, 246f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzM4ODMxIiwibmFtZSI6Im11bGUgZGVlciIsImRlc2NyaXB0aW9uIjoiZGVlciBpbmRpZ2Vub3VzIHRvIHdlc3Rlcm4gTm9ydGggQW1lcmljYTsgbmFtZWQgZm9yIGxhcmdlIGVhcnMgcmVzZW1ibGluZyBtdWxlIn0seyJpZCI6IlEyMTU4ODciLCJuYW1lIjoid2hpdGUtdGFpbGVkIGRlZXIiLCJkZXNjcmlwdGlvbiI6InNwZWNpZXMgb2YgbWFtbWFsIn0seyJpZCI6IlE3MjkiLCJuYW1lIjoiYW5pbWFsIiwiZGVzY3JpcHRpb24iOiJraW5nZG9tIG9mIG11bHRpY2VsbHVsYXIgZXVrYXJ5b3RpYyBvcmdhbmlzbXMifSx7ImlkIjoiUTQ0MjEiLCJuYW1lIjoiZm9yZXN0IiwiZGVzY3JpcHRpb24iOiJkZW5zZSBjb2xsZWN0aW9uIG9mIHRyZWVzIGNvdmVyaW5nIGEgcmVsYXRpdmVseSBsYXJnZSBhcmVhIn1d"
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzk0OTUiLCJuYW1lIjoidHJhY3RvciIsImRlc2NyaXB0aW9uIjoiZW5naW5lZXJpbmcgdmVoaWNsZSBzcGVjaWZpY2FsbHkgZGVzaWduZWQgdG8gZGVsaXZlciBhIGhpZ2ggdHJhY3RpdmUgZWZmb3J0In1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzk0OTUiLCJuYW1lIjoidHJhY3RvciIsImRlc2NyaXB0aW9uIjoiZW5naW5lZXJpbmcgdmVoaWNsZSBzcGVjaWZpY2FsbHkgZGVzaWduZWQgdG8gZGVsaXZlciBhIGhpZ2ggdHJhY3RpdmUgZWZmb3J0In0seyJpZCI6IlEzMTQyIiwibmFtZSI6InJlZCIsImRlc2NyaXB0aW9uIjoiY29sb3IifSx7ImlkIjoiUTIzNDQ0IiwibmFtZSI6IndoaXRlIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRMTM5MjI4NyIsIm5hbWUiOiJyb2FkIHN1cmZhY2UgbWFya2luZyIsImRlc2NyaXB0aW9uIjoiYW55IGtpbmQgb2YgZGV2aWNlIG9yIG1hdGVyaWFsIHVzZWQgb24gYSByb2FkIHN1cmZhY2UgdG8gY29udmV5IG9mZmljaWFsIGluZm9ybWF0aW9uIn0seyJpZCI6IlExODg4NjkiLCJuYW1lIjoiZmllbGQiLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2YgbGFuZCB1c2VkIGZvciBhZ3JpY3VsdHVyYWwgcHVycG9zZXMifSx7ImlkIjoiUTIxMDgyNjUzIiwibmFtZSI6ImFncmljdWx0dXJhbCBlcXVpcG1lbnQiLCJkZXNjcmlwdGlvbiI6ImVxdWlwbWVudCB1c2VkIGZvciBmYXJtaW5nIn0seyJpZCI6IlExMzE1OTYiLCJuYW1lIjoiZmFybSIsImRlc2NyaXB0aW9uIjoiYXJlYSBvZiBsYW5kIGZvciBmYXJtaW5nLCBvciwgZm9yIGFxdWFjdWx0dXJlLCBsYWtlLCByaXZlciBvciBzZWEsIGluY2x1ZGluZyB2YXJpb3VzIHN0cnVjdHVyZXMifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjM1MzUyIiwibmFtZSI6ImNyb3AiLCJkZXNjcmlwdGlvbiI6InBsYW50IG9yIGFuaW1hbCBwcm9kdWN0IHRoYXQgY2FuIGJlIGdyb3duIGFuZCBoYXJ2ZXN0ZWQgZXh0ZW5zaXZlbHkgZm9yIHByb2ZpdCBvciBzdWJzaXN0ZW5jZSJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask7(
    override val poolId: String = "07",
    override val result: Result = Result("v_03670", 23f, 43f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "Manager"
                    )
                )
            ),
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE3ODY1MSIsIm5hbWUiOiJpbnRlcnZpZXciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZWQgc2VyaWVzIG9mIHF1ZXN0aW9ucyBhbmQgYW5zd2VycyJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTE0NDIiLCJuYW1lIjoiYmljeWNsZSIsImRlc2NyaXB0aW9uIjoicGVkYWwtZHJpdmVuIHR3by13aGVlbCB2ZWhpY2xlIn0seyJpZCI6IlE3NzE0NTIiLCJuYW1lIjoiYmljeWNsZSB0aXJlIiwiZGVzY3JpcHRpb24iOiJhIHRpcmUgdGhhdCBmaXRzIG9uIHRoZSB3aGVlbCBvZiBhIGJpY3ljbGUifSx7ImlkIjoiUTE2MTk3MyIsIm5hbWUiOiJjdXJ2ZSIsImRlc2NyaXB0aW9uIjoibWF0aGVtYXRpY2FsIGlkZWFsaXphdGlvbiBvZiB0aGUgdHJhY2UgbGVmdCBieSBhIG1vdmluZyBwb2ludCJ9LHsiaWQiOiJRMzQ0NDIiLCJuYW1lIjoicm9hZCIsImRlc2NyaXB0aW9uIjoid2F5IG9uIGxhbmQgYmV0d2VlbiB0d28gcGxhY2VzIn0seyJpZCI6IlE0Mjg4OSIsIm5hbWUiOiJ2ZWhpY2xlIiwiZGVzY3JpcHRpb24iOiJtb2JpbGUgbWFjaGluZSB0aGF0IHRyYW5zcG9ydHMgcGVvcGxlLCBhbmltYWxzIG9yIGNhcmdvIn0seyJpZCI6IlEyMjkzODU3NiIsIm5hbWUiOiJyYWNlIiwiZGVzY3JpcHRpb24iOiJjb21wZXRpdGl2ZSBldmVudCBpbiB3aGljaCBwYXJ0aWNpcGFudHMgYXR0ZW1wdCB0byBjb21wbGV0ZSBvYmplY3RpdmVzIGFzIGZhc3QgYXMgcG9zc2libGUifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTEyNzQ4MyIsIm5hbWUiOiJiaWN5Y2xlIGhlbG1ldCIsImRlc2NyaXB0aW9uIjoiaGVsbWV0IGZvciBwZW9wbGUgb24gYmljeWNsZXMgaW50ZW5kZWQgdG8gcmVkdWNlIGluanVyaWVzIGluIHRoZSBldmVudCBvZiBhIGNvbGxpc2lvbiBvciBjcmFzaCJ9LHsiaWQiOiJRMzYwOSIsIm5hbWUiOiJyb2FkIGJpY3ljbGUgcmFjaW5nIiwiZGVzY3JpcHRpb24iOiJiaWN5Y2xlIHJhY2luZyBzcG9ydCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjYzODIiLCJuYW1lIjoic2lkZSIsImRlc2NyaXB0aW9uIjoibGluZSBzZWdtZW50IGpvaW5pbmcgdHdvIGFkamFjZW50IHZlcnRpY2VzIGluIGEgcG9seWdvbiBvciBwb2x5dG9wZSJ9LHsiaWQiOiJRMTY4ODczODAiLCJuYW1lIjoiZ3JvdXAiLCJkZXNjcmlwdGlvbiI6InN1bW1hcml6ZXMgZW50aXRpZXMgd2l0aCBzaW1pbGFyIGNoYXJhY3RlcmlzdGljcyB0b2dldGhlciJ9LHsiaWQiOiJRMTE0NDIiLCJuYW1lIjoiYmljeWNsZSIsImRlc2NyaXB0aW9uIjoicGVkYWwtZHJpdmVuIHR3by13aGVlbCB2ZWhpY2xlIn0seyJpZCI6IlEyMjkzODU3NiIsIm5hbWUiOiJyYWNlIiwiZGVzY3JpcHRpb24iOiJjb21wZXRpdGl2ZSBldmVudCBpbiB3aGljaCBwYXJ0aWNpcGFudHMgYXR0ZW1wdCB0byBjb21wbGV0ZSBvYmplY3RpdmVzIGFzIGZhc3QgYXMgcG9zc2libGUifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask8(
    override val poolId: String = "08",
    override val result: Result = Result("v_03491", 656f, 676f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTgwNTE2IiwibmFtZSI6InJvb20iLCJkZXNjcmlwdGlvbiI6ImRpc3Rpbmd1aXNoYWJsZSBzcGFjZSB3aXRoaW4gYSBidWlsZGluZyBvciBvdGhlciBzdHJ1Y3R1cmUifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMjEzNDc3IiwibmFtZSI6InRlZGR5IGJlYXIiLCJkZXNjcmlwdGlvbiI6InNvZnQgdG95IGluIHRoZSBmb3JtIG9mIGEgYmVhciJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTkxOTMxIiwibmFtZSI6IndoZWVsY2hhaXIiLCJkZXNjcmlwdGlvbiI6ImNoYWlyIHdpdGggd2hlZWxzLCB1c2VkIGJ5IHBlb3BsZSBmb3Igd2hvbSB3YWxraW5nIGlzIGRpZmZpY3VsdCBvciBpbXBvc3NpYmxlIGR1ZSB0byBpbGxuZXNzLCBpbmp1cnksIG9yIGRpc2FiaWxpdHkifSx7ImlkIjoiUTE4ODY2OSIsIm5hbWUiOiJmaXJlcGxhY2UiLCJkZXNjcmlwdGlvbiI6ImRldmljZSBmb3IgZmlyaW5nIHNvbGlkIGZ1ZWxzIGluIHJlc2lkZW50aWFsIGJ1aWxkaW5ncyJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjQ3MjU4NyIsIm5hbWUiOiJwZW9wbGUiLCJkZXNjcmlwdGlvbiI6InBsdXJhbGl0eSBvZiBwZXJzb25zIGNvbnNpZGVyZWQgYXMgYSB3aG9sZSwgZnJvbSBhIGdvdmVybm1lbnQgcGVyc3BlY3RpdmUifSx7ImlkIjoiUTEyODIzMTA1IiwibmFtZSI6Im9mZmljZSIsImRlc2NyaXB0aW9uIjoicm9vbSB3aGVyZSBwZW9wbGUgcGVyZm9ybSB0aGVpciBkdXRpZXMifSx7ImlkIjoiUTU2MTU1IiwibmFtZSI6ImRlc2t0b3AgY29tcHV0ZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbmFsIGNvbXB1dGVyIGluIGEgZm9ybSBpbnRlbmRlZCBmb3IgcmVndWxhciB1c2UgYXQgYSBzaW5nbGUgbG9jYXRpb24gZGVzay90YWJsZSJ9LHsiaWQiOiJRMTAyMTY4NiIsIm5hbWUiOiJvZmZpY2UgY2hhaXIiLCJkZXNjcmlwdGlvbiI6InNlYXRpbmcgZm9yIG9mZmljZSB3b3JrZXIifSx7ImlkIjoiUTE2NTMyMjc2IiwibmFtZSI6IndvcmsiLCJkZXNjcmlwdGlvbiI6ImFjdGl2aXR5IGRvbmUgYnkgYSBwZXJzb24gdG8gZWFybiBhIGxpdmluZyJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask9(
    override val poolId: String = "09",
    override val result: Result = Result("v_06836", 283f, 305f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTM5NTQ2IiwibmFtZSI6InRvb2wiLCJkZXNjcmlwdGlvbiI6InBoeXNpY2FsIGl0ZW0gdGhhdCBjYW4gYmUgdXNlZCB0byBhY2hpZXZlIGEgZ29hbCJ9LHsiaWQiOiJRMTg3ODMzIiwibmFtZSI6ImxhdGhlIiwiZGVzY3JpcHRpb24iOiJtYWNoaW5lIHRvb2wgd2hpY2ggcm90YXRlcyB0aGUgd29ya3BpZWNlIG9uIGl0cyBheGlzIn0seyJpZCI6IlExNDI5MDQ1NyIsIm5hbWUiOiJjaGVjayIsImRlc2NyaXB0aW9uIjoicGF0dGVybiBvZiBpbnRlcnNlY3RpbmcgdmVydGljYWwgYW5kIGhvcml6b250YWwgbGluZXMifSx7ImlkIjoiUTc2NzY4IiwibmFtZSI6InNoaXJ0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB0aGUgdXBwZXIgYm9keSJ9LHsiaWQiOiJRNDIyMTMiLCJuYW1lIjoid29yayIsImRlc2NyaXB0aW9uIjoiZW5lcmd5IHRyYW5zZmVycmVkIHRvIGFuIG9iamVjdCB2aWEgdGhlIGFwcGxpY2F0aW9uIG9mIGZvcmNlIG9uIGl0IHRocm91Z2ggYSBkaXNwbGFjZW1lbnQifSx7ImlkIjoiUTE2NTMyMjc2IiwibmFtZSI6IndvcmsiLCJkZXNjcmlwdGlvbiI6ImFjdGl2aXR5IGRvbmUgYnkgYSBwZXJzb24gdG8gZWFybiBhIGxpdmluZyJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTc4Nzk0IiwibmFtZSI6IndhdGNoIiwiZGVzY3JpcHRpb24iOiJwZXJzb25hbCB0aW1lcGllY2UifSx7ImlkIjoiUTQzNDcxIiwibmFtZSI6ImFybSIsImRlc2NyaXB0aW9uIjoicHJveGltYWwgcGFydCBvZiB0aGUgZnJlZSB1cHBlciBsaW1iIGJldHdlZW4gdGhlIHNob3VsZGVyIGFuZCB0aGUgZWxib3cifSx7ImlkIjoiUTc2NzY4IiwibmFtZSI6InNoaXJ0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB0aGUgdXBwZXIgYm9keSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNjUyIiwibmFtZSI6Ikl0YWxpYW4iLCJkZXNjcmlwdGlvbiI6IlJvbWFuY2UgbGFuZ3VhZ2UifSx7ImlkIjoiUTg0NDEiLCJuYW1lIjoibWFuIiwiZGVzY3JpcHRpb24iOiJtYWxlIGFkdWx0IGh1bWFuIn0seyJpZCI6IlEzNzUwMSIsIm5hbWUiOiJleWVnbGFzc2VzIiwiZGVzY3JpcHRpb24iOiJhY2Nlc3NvcmllcyB0aGF0IGltcHJvdmUgaHVtYW4gdmlzaW9uIn0seyJpZCI6IlExNzg2NTEiLCJuYW1lIjoiaW50ZXJ2aWV3IiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmVkIHNlcmllcyBvZiBxdWVzdGlvbnMgYW5kIGFuc3dlcnMifSx7ImlkIjoiUTE1MzI4IiwibmFtZSI6ImNhbWVyYSIsImRlc2NyaXB0aW9uIjoib3B0aWNhbCBkZXZpY2UgZm9yIHJlY29yZGluZyBvciB0cmFuc21pdHRpbmcgcGhvdG9ncmFwaGljIGltYWdlcyBvciB2aWRlb3MifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTUzMjgiLCJuYW1lIjoiY2FtZXJhIiwiZGVzY3JpcHRpb24iOiJvcHRpY2FsIGRldmljZSBmb3IgcmVjb3JkaW5nIG9yIHRyYW5zbWl0dGluZyBwaG90b2dyYXBoaWMgaW1hZ2VzIG9yIHZpZGVvcyJ9LHsiaWQiOiJRMjYzNzgxNCIsIm5hbWUiOiJyYWNrIG9mIHNoZWx2ZXMiLCJkZXNjcmlwdGlvbiI6InNldCBvZiBzaGVsdmVzLCBjb21iaW5lZCBpbnRvIG9uZSBwaWVjZSBvZiBmdXJuaXR1cmUifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask10(
    override val poolId: String = "10",
    override val result: Result = Result("v_01561", 450f, 675f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNjAwMzk2IiwibmFtZSI6ImZpc2giLCJkZXNjcmlwdGlvbiI6ImZvb2QgY29uc3VtZWQgYnkgbWFueSBzcGVjaWVzLCBpbmNsdWRpbmcgaHVtYW5zIn1d"
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzM4MCIsIm5hbWUiOiJwcmltYXRlIiwiZGVzY3JpcHRpb24iOiJvcmRlciBvZiBtYW1tYWxzIn0seyJpZCI6IlExMzY3IiwibmFtZSI6Im1vbmtleSIsImRlc2NyaXB0aW9uIjoiYW5pbWFsIG9mIHRoZSBcXFwiaGlnaGVyIHByaW1hdGVzXFxcIiAodGhlIHNpbWlhbnMpIn0seyJpZCI6IlE2MDQ3MzMiLCJuYW1lIjoicHJlc2VudGF0aW9uIiwiZGVzY3JpcHRpb24iOiJwcm9jZXNzIG9mIHByZXNlbnRpbmcgYSB0b3BpYyB0byBhbiBhdWRpZW5jZSBzZXR0aW5nIHRoZSBTY2VuZSBvbiB0aGUgQWdlbmRhIn0seyJpZCI6IlE0Nzg3OTgiLCJuYW1lIjoiaW1hZ2UiLCJkZXNjcmlwdGlvbiI6ImFydGlmYWN0IHRoYXQgZGVwaWN0cyBvciByZWNvcmRzIHZpc3VhbCBwZXJjZXB0aW9uIn0seyJpZCI6IlE3MjkiLCJuYW1lIjoiYW5pbWFsIiwiZGVzY3JpcHRpb24iOiJraW5nZG9tIG9mIG11bHRpY2VsbHVsYXIgZXVrYXJ5b3RpYyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDA4MzEiLCJuYW1lIjoiY29tZWR5IiwiZGVzY3JpcHRpb24iOiJnZW5yZSBvZiBkcmFtYXRpYyB3b3JrcyBpbnRlbmRlZCB0byBiZSBodW1vcm91cyJ9LHsiaWQiOiJRMTk0NDI4IiwibmFtZSI6InN0YWdlIiwiZGVzY3JpcHRpb24iOiJkZXNpZ25hdGVkIHNwYWNlIGZvciB0aGUgcGVyZm9ybWFuY2Ugb2YgcHJvZHVjdGlvbnMifSx7ImlkIjoiUTIxMzE1NiIsIm5hbWUiOiJwZXJmb3JtYW5jZSBhcnQiLCJkZXNjcmlwdGlvbiI6ImFydGlzdGljIHBlcmZvcm1hbmNlIHByZXNlbnRlZCB0byBhbiBhdWRpZW5jZSJ9LHsiaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTI0NTA2OCIsIm5hbWUiOiJjb21lZGlhbiIsImRlc2NyaXB0aW9uIjoicGVyc29uIHdobyBzZWVrcyB0byBlbnRlcnRhaW4gYW4gYXVkaWVuY2UsIHByaW1hcmlseSBieSBtYWtpbmcgdGhlbSBsYXVnaCJ9LHsiaWQiOiJRNDYzODQiLCJuYW1lIjoibWljcm9waG9uZSIsImRlc2NyaXB0aW9uIjoiYWNvdXN0aWMtdG8tZWxlY3RyaWMgdHJhbnNkdWNlciBvciBzZW5zb3IgdGhhdCBjb252ZXJ0cyBzb3VuZCBpbnRvIGFuIGVsZWN0cmljYWwgc2lnbmFsIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTExMyIsIm5hbWUiOiJiaXJkIiwiZGVzY3JpcHRpb24iOiJjbGFzcyBvZiB0ZXRyYXBvZHMifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask11(
    override val poolId: String = "11",
    override val result: Result = Result("v_05057", 60f, 80f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "Manager"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE3ODY1MSIsIm5hbWUiOiJpbnRlcnZpZXciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZWQgc2VyaWVzIG9mIHF1ZXN0aW9ucyBhbmQgYW5zd2VycyJ9LHsiaWQiOiJRNDI5MDQxNzEiLCJuYW1lIjoidm90ZSIsImRlc2NyaXB0aW9uIjoiY2hvaWNlIG1hZGUgaW4gYW4gZWxlY3Rpb24ifSx7ImlkIjoiUTExNzA0IiwibmFtZSI6IkVsZWN0aW9uIERheSIsImRlc2NyaXB0aW9uIjoiZGF5IGZvciB0aGUgZ2VuZXJhbCBlbGVjdGlvbnMgb2YgcHVibGljIG9mZmljaWFscyBpbiB0aGUgVVMifSx7ImlkIjoiUTQwMjMxIiwibmFtZSI6ImVsZWN0aW9uIiwiZGVzY3JpcHRpb24iOiJwcm9jZXNzIGJ5IHdoaWNoIGEgcG9wdWxhdGlvbiBjaG9vc2VzIGFuIGluZGl2aWR1YWwgdG8gaG9sZCBwdWJsaWMgb2ZmaWNlIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE3ODY1MSIsIm5hbWUiOiJpbnRlcnZpZXciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZWQgc2VyaWVzIG9mIHF1ZXN0aW9ucyBhbmQgYW5zd2VycyJ9LHsiaWQiOiJRMTE3MDQiLCJuYW1lIjoiRWxlY3Rpb24gRGF5IiwiZGVzY3JpcHRpb24iOiJkYXkgZm9yIHRoZSBnZW5lcmFsIGVsZWN0aW9ucyBvZiBwdWJsaWMgb2ZmaWNpYWxzIGluIHRoZSBVUyJ9LHsiaWQiOiJRNDAyMzEiLCJuYW1lIjoiZWxlY3Rpb24iLCJkZXNjcmlwdGlvbiI6InByb2Nlc3MgYnkgd2hpY2ggYSBwb3B1bGF0aW9uIGNob29zZXMgYW4gaW5kaXZpZHVhbCB0byBob2xkIHB1YmxpYyBvZmZpY2UifSx7ImlkIjoiUTMwIiwibmFtZSI6IlVuaXRlZCBTdGF0ZXMgb2YgQW1lcmljYSIsImRlc2NyaXB0aW9uIjoic292ZXJlaWduIHN0YXRlIGluIE5vcnRoIEFtZXJpY2EifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTgwNTE2IiwibmFtZSI6InJvb20iLCJkZXNjcmlwdGlvbiI6ImRpc3Rpbmd1aXNoYWJsZSBzcGFjZSB3aXRoaW4gYSBidWlsZGluZyBvciBvdGhlciBzdHJ1Y3R1cmUifSx7ImlkIjoiUTE3ODY1MSIsIm5hbWUiOiJpbnRlcnZpZXciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZWQgc2VyaWVzIG9mIHF1ZXN0aW9ucyBhbmQgYW5zd2VycyJ9LHsiaWQiOiJRMTI3NzYxODQiLCJuYW1lIjoid2FsayIsImRlc2NyaXB0aW9uIjoic2VxdWVuY2Ugb2YgZWRnZXMgY29ubmVjdGluZyBhIHNlcXVlbmNlIG9mIHZlcnRpY2VzIGluIGEgZ3JhcGgifSx7ImlkIjoiUTI4NTAzNzUxIiwibmFtZSI6InNwZWFrZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiBjYXBhYmxlIG9mIHZlcmJhbCBjb21tdW5pY2F0aW9uIn0seyJpZCI6IlE0NjciLCJuYW1lIjoid29tYW4iLCJkZXNjcmlwdGlvbiI6ImZlbWFsZSBhZHVsdCBodW1hbiJ9LHsiaWQiOiJRNDAyMzEiLCJuYW1lIjoiZWxlY3Rpb24iLCJkZXNjcmlwdGlvbiI6InByb2Nlc3MgYnkgd2hpY2ggYSBwb3B1bGF0aW9uIGNob29zZXMgYW4gaW5kaXZpZHVhbCB0byBob2xkIHB1YmxpYyBvZmZpY2UifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask12(
    override val poolId: String = "12",
    override val result: Result = Result("v_02731", 15f, 85f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTIyODAiLCJuYW1lIjoiYnJpZGdlIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUgYnVpbHQgdG8gc3BhbiBwaHlzaWNhbCBvYnN0YWNsZXMifV0="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "saint"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzI2IiwibmFtZSI6ImhvcnNlIiwiZGVzY3JpcHRpb24iOiJkb21lc3RpY2F0ZWQgKHdvcmspIGFuaW1hbCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTMyMjQxIiwibmFtZSI6ImZlc3RpdmFsIiwiZGVzY3JpcHRpb24iOiJjZWxlYnJhdGlvbiB0aGF0IGZvY3VzZXMgdXBvbiBhIHRoZW1lLCBhbmQgbWF5IHJ1biBmb3IgaG91cnMgdG8gd2Vla3M7IHVzdWFsbHkgcmVwZWF0ZWQgcmVndWxhcmlseSwgZWcuIG9uY2UgYSB5ZWFyIn0seyJpZCI6IlEzMDEwMjA1IiwibmFtZSI6ImNlbGVicmF0aW9uIiwiZGVzY3JpcHRpb24iOiJzb2NpYWwgZXZlbnQifSx7ImlkIjoiUTYzOCIsIm5hbWUiOiJtdXNpYyIsImRlc2NyaXB0aW9uIjoiZm9ybSBvZiBhcnQgdXNpbmcgc291bmQgc3BlY2lmaWNhbGx5In0seyJpZCI6IlE2Mzk2NjkiLCJuYW1lIjoibXVzaWNpYW4iLCJkZXNjcmlwdGlvbiI6ImFydGlzdCB3aG8gcGVyZm9ybXMgb3IgY29tcG9zZXMgbXVzaWM7IGFueW9uZSB3aG8gY29tcG9zZXMsIGNvbmR1Y3RzLCBvciBwZXJmb3JtcyBtdXNpYyJ9LHsiaWQiOiJRMTE2MzkiLCJuYW1lIjoiZGFuY2UiLCJkZXNjcmlwdGlvbiI6InJoeXRobWljIG1vdmVtZW50IG9mIHRoZSBib2R5In0seyJpZCI6IlE1NzUiLCJuYW1lIjoibmlnaHQiLCJkZXNjcmlwdGlvbiI6InBlcmlvZCBmcm9tIHN1bnNldCB0byBzdW5yaXNlIGluIGVhY2ggdHdlbnR5LWZvdXIgaG91cnMifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask13(
    override val poolId: String = "13",
    override val result: Result = Result("v_03284", 160f, 183f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlE4MzM2MyIsIm5hbWUiOiJqZWFucyIsImRlc2NyaXB0aW9uIjoidHJvdXNlcnMgb2Z0ZW4gbWFkZSBmcm9tIGRlbmltIG9yIGR1bmdhcmVlIGNsb3RoIn0seyJpZCI6IlE3NTY5IiwibmFtZSI6ImNoaWxkIiwiZGVzY3JpcHRpb24iOiJodW1hbiBiZXR3ZWVuIHRoZSBzdGFnZXMgb2YgYmlydGggYW5kIHB1YmVydHkifSx7ImlkIjoiUTExNDY5IiwibmFtZSI6ImdsYXNzIiwiZGVzY3JpcHRpb24iOiJhbW9ycGhvdXMgc29saWQgdGhhdCBleGhpYml0cyBhIGdsYXNzIHRyYW5zaXRpb24gd2hlbiBoZWF0ZWQgdG93YXJkcyB0aGUgbGlxdWlkIHN0YXRlIn0seyJpZCI6IlExNDc0OCIsIm5hbWUiOiJ0YWJsZSIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHdpdGggYSBmbGF0IHRvcCJ9LHsiaWQiOiJRMjI4NTciLCJuYW1lIjoiY2xpbWJpbmciLCJkZXNjcmlwdGlvbiI6ImFjdGl2aXR5IHRvIGFzY2VuZCBhIHN0ZWVwIG9iamVjdCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODMzNjMiLCJuYW1lIjoiamVhbnMiLCJkZXNjcmlwdGlvbiI6InRyb3VzZXJzIG9mdGVuIG1hZGUgZnJvbSBkZW5pbSBvciBkdW5nYXJlZSBjbG90aCJ9LHsiaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlE0MjE3NyIsIm5hbWUiOiJiZWQiLCJkZXNjcmlwdGlvbiI6InBpZWNlIG9mIGZ1cm5pdHVyZSB1c2VkIGFzIGEgcGxhY2UgdG8gc2xlZXAgb3IgcmVsYXgifSx7ImlkIjoiUTE0NzQ4IiwibmFtZSI6InRhYmxlIiwiZGVzY3JpcHRpb24iOiJwaWVjZSBvZiBmdXJuaXR1cmUgd2l0aCBhIGZsYXQgdG9wIn0seyJpZCI6IlEyMjg1NyIsIm5hbWUiOiJjbGltYmluZyIsImRlc2NyaXB0aW9uIjoiYWN0aXZpdHkgdG8gYXNjZW5kIGEgc3RlZXAgb2JqZWN0In1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDIxNzciLCJuYW1lIjoiYmVkIiwiZGVzY3JpcHRpb24iOiJwaWVjZSBvZiBmdXJuaXR1cmUgdXNlZCBhcyBhIHBsYWNlIHRvIHNsZWVwIG9yIHJlbGF4In0seyJpZCI6IlExMTUxNzUyIiwibmFtZSI6Imp1bXBpbmciLCJkZXNjcmlwdGlvbiI6ImZvcm0gb2YgbG9jb21vdGlvbiBvciBtb3ZlbWVudCJ9LHsiaWQiOiJRNzU2OSIsIm5hbWUiOiJjaGlsZCIsImRlc2NyaXB0aW9uIjoiaHVtYW4gYmV0d2VlbiB0aGUgc3RhZ2VzIG9mIGJpcnRoIGFuZCBwdWJlcnR5In0seyJpZCI6IlEyMTU2MjciLCJuYW1lIjoicGVyc29uIiwiZGVzY3JpcHRpb24iOiJiZWluZyB0aGF0IGhhcyBjZXJ0YWluIGNhcGFjaXRpZXMgb3IgYXR0cmlidXRlcyBjb25zdGl0dXRpbmcgcGVyc29uaG9vZCAoYXZvaWQgdXNlIHdpdGggUDMxOyB1c2UgUTUgZm9yIGh1bWFucykifSx7ImlkIjoiUTE1MzI4IiwibmFtZSI6ImNhbWVyYSIsImRlc2NyaXB0aW9uIjoib3B0aWNhbCBkZXZpY2UgZm9yIHJlY29yZGluZyBvciB0cmFuc21pdHRpbmcgcGhvdG9ncmFwaGljIGltYWdlcyBvciB2aWRlb3MifSx7ImlkIjoiUTc2NzY4IiwibmFtZSI6InNoaXJ0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB0aGUgdXBwZXIgYm9keSJ9LHsiaWQiOiJRODMzNjMiLCJuYW1lIjoiamVhbnMiLCJkZXNjcmlwdGlvbiI6InRyb3VzZXJzIG9mdGVuIG1hZGUgZnJvbSBkZW5pbSBvciBkdW5nYXJlZSBjbG90aCJ9LHsiaWQiOiJRMTA4OCIsIm5hbWUiOiJibHVlIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgYW5kIHN1YnRyYWN0aXZlIChSWUIpIHByaW1hcnkgY29sb3I7IHZpc2libGUgYmV0d2VlbiBwdXJwbGUgYW5kIGdyZWVuIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQzNiIsIm5hbWUiOiJmYW1pbHkiLCJkZXNjcmlwdGlvbiI6Imdyb3VwIG9mIHBlb3BsZSBhZmZpbGlhdGVkIGJ5IGNvbnNhbmd1aW5pdHksIGFmZmluaXR5LCBvciBjby1yZXNpZGVuY2UifSx7ImlkIjoiUTc1NjAiLCJuYW1lIjoibW90aGVyIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgcGFyZW50In0seyJpZCI6IlE3NTY1IiwibmFtZSI6ImZhdGhlciIsImRlc2NyaXB0aW9uIjoibWFsZSBwYXJlbnQifSx7ImlkIjoiUTY1ODEwOTciLCJuYW1lIjoibWFsZSIsImRlc2NyaXB0aW9uIjoidG8gYmUgdXNlZCBpbiBcXFwic2V4IG9yIGdlbmRlclxcXCIgKFAyMSkgdG8gaW5kaWNhdGUgdGhhdCB0aGUgaHVtYW4gc3ViamVjdCBpZGVudGlmaWVzIGFzIG1hbGUifSx7ImlkIjoiUTY1ODEwNzIiLCJuYW1lIjoiZmVtYWxlIiwiZGVzY3JpcHRpb24iOiJ0byBiZSB1c2VkIGluIFxcXCJzZXggb3IgZ2VuZGVyXFxcIiAoUDIxKSB0byBpbmRpY2F0ZSB0aGF0IHRoZSBodW1hbiBzdWJqZWN0IGlkZW50aWZpZXMgYXMgZmVtYWxlIn0seyJpZCI6IlExNjg4NzM4MCIsIm5hbWUiOiJncm91cCIsImRlc2NyaXB0aW9uIjoic3VtbWFyaXplcyBlbnRpdGllcyB3aXRoIHNpbWlsYXIgY2hhcmFjdGVyaXN0aWNzIHRvZ2V0aGVyIn0seyJpZCI6IlExMTQ0NTkzIiwibmFtZSI6InNpdHRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHJlc3RpbmcgcG9zaXRpb247IGJvZHkgd2VpZ2h0IGlzIHN1cHBvcnRlZCBwcmltYXJpbHkgYnkgdGhlIGJ1dHRvY2tzIGluIGNvbnRhY3Qgd2l0aCB0aGUgZ3JvdW5kIG9yIGEgaG9yaXpvbnRhbCBvYmplY3Qgc3VjaCBhcyBhIGNoYWlyIn0seyJpZCI6IlE3NTY5IiwibmFtZSI6ImNoaWxkIiwiZGVzY3JpcHRpb24iOiJodW1hbiBiZXR3ZWVuIHRoZSBzdGFnZXMgb2YgYmlydGggYW5kIHB1YmVydHkifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask14(
    override val poolId: String = "14",
    override val result: Result = Result("v_06722", 30f, 49f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDM0NzEiLCJuYW1lIjoiYXJtIiwiZGVzY3JpcHRpb24iOiJwcm94aW1hbCBwYXJ0IG9mIHRoZSBmcmVlIHVwcGVyIGxpbWIgYmV0d2VlbiB0aGUgc2hvdWxkZXIgYW5kIHRoZSBlbGJvdyJ9LHsiaWQiOiJRMTA4OCIsIm5hbWUiOiJibHVlIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgYW5kIHN1YnRyYWN0aXZlIChSWUIpIHByaW1hcnkgY29sb3I7IHZpc2libGUgYmV0d2VlbiBwdXJwbGUgYW5kIGdyZWVuIn0seyJpZCI6IlE5NzA2IiwibmFtZSI6ImJhbGxvb24iLCJkZXNjcmlwdGlvbiI6ImluZmxhdGFibGUgZmxleGlibGUgYmFnIGZpbGxlZCB3aXRoIGdhcyJ9LHsiaWQiOiJRMTA3NSIsIm5hbWUiOiJjb2xvciIsImRlc2NyaXB0aW9uIjoidmlzdWFsIHBlcmNlcHRpb24gb2YgbGlnaHQgd2F2ZWxlbmd0aHMifV0="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE2ODg3MzgwIiwibmFtZSI6Imdyb3VwIiwiZGVzY3JpcHRpb24iOiJzdW1tYXJpemVzIGVudGl0aWVzIHdpdGggc2ltaWxhciBjaGFyYWN0ZXJpc3RpY3MgdG9nZXRoZXIifSx7ImlkIjoiUTQ2Mzg0IiwibmFtZSI6Im1pY3JvcGhvbmUiLCJkZXNjcmlwdGlvbiI6ImFjb3VzdGljLXRvLWVsZWN0cmljIHRyYW5zZHVjZXIgb3Igc2Vuc29yIHRoYXQgY29udmVydHMgc291bmQgaW50byBhbiBlbGVjdHJpY2FsIHNpZ25hbCJ9LHsiaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTg0OTk2NCIsIm5hbWUiOiJqYWNrZXQiLCJkZXNjcmlwdGlvbiI6ImNsb3RoaW5nIGZvciB0aGUgdXBwZXIgYm9keSJ9LHsiaWQiOiJRMTA4OCIsIm5hbWUiOiJibHVlIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgYW5kIHN1YnRyYWN0aXZlIChSWUIpIHByaW1hcnkgY29sb3I7IHZpc2libGUgYmV0d2VlbiBwdXJwbGUgYW5kIGdyZWVuIn0seyJpZCI6IlExOTEwMjIiLCJuYW1lIjoic2NhcmYiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgb2YgZmFicmljIHdvcm4gYXJvdW5kIG5lY2sgb3IgaGVhZCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzU2OSIsIm5hbWUiOiJjaGlsZCIsImRlc2NyaXB0aW9uIjoiaHVtYW4gYmV0d2VlbiB0aGUgc3RhZ2VzIG9mIGJpcnRoIGFuZCBwdWJlcnR5In0seyJpZCI6IlExMTQ0NTkzIiwibmFtZSI6InNpdHRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHJlc3RpbmcgcG9zaXRpb247IGJvZHkgd2VpZ2h0IGlzIHN1cHBvcnRlZCBwcmltYXJpbHkgYnkgdGhlIGJ1dHRvY2tzIGluIGNvbnRhY3Qgd2l0aCB0aGUgZ3JvdW5kIG9yIGEgaG9yaXpvbnRhbCBvYmplY3Qgc3VjaCBhcyBhIGNoYWlyIn0seyJpZCI6IlExNjg4NzM4MCIsIm5hbWUiOiJncm91cCIsImRlc2NyaXB0aW9uIjoic3VtbWFyaXplcyBlbnRpdGllcyB3aXRoIHNpbWlsYXIgY2hhcmFjdGVyaXN0aWNzIHRvZ2V0aGVyIn0seyJpZCI6IlEyMTcxNjQiLCJuYW1lIjoiZmxvb3IiLCJkZXNjcmlwdGlvbiI6IndhbGtpbmcgc3VyZmFjZSBvZiBhIHJvb20ifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjQwODU0IiwibmFtZSI6ImhhbGwiLCJkZXNjcmlwdGlvbiI6ImxhcmdlIHJvb20gdXNlZCBmb3IgbWVldGluZ3MsIHNvY2lhbCBhZmZhaXJzIG9yIGV2ZW50cyJ9LHsiaWQiOiJRMTI0OTMiLCJuYW1lIjoiZG9tZSIsImRlc2NyaXB0aW9uIjoiYXJjaGl0ZWN0dXJhbCBlbGVtZW50IHRoYXQgcmVzZW1ibGVzIHRoZSBob2xsb3cgdXBwZXIgaGFsZiBvZiBhIHNwaGVyZSJ9LHsiaWQiOiJRMTY1NjY4MiIsIm5hbWUiOiJldmVudCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IGFuZCBzY2hlZHVsZWQgZXZlbnQsIGxpa2UgYSBmZXN0aXZhbCBvciBjb21wZXRpdGlvbiJ9LHsiaWQiOiJRNjM4IiwibmFtZSI6Im11c2ljIiwiZGVzY3JpcHRpb24iOiJmb3JtIG9mIGFydCB1c2luZyBzb3VuZCBzcGVjaWZpY2FsbHkifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask15(
    override val poolId: String = "15",
    override val result: Result = Result("v_04964", 102f, 122f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzcxNzIiLCJuYW1lIjoid2F2ZSIsImRlc2NyaXB0aW9uIjoiUmVwZWF0ZWQgb3NjaWxsYXRpb24gYWJvdXQgYSBzdGFibGUgZXF1aWxpYnJpdW0ifSx7ImlkIjoiUTk0MzAiLCJuYW1lIjoib2NlYW4iLCJkZXNjcmlwdGlvbiI6ImxhcmdlIGJvZHkgb2Ygc2FsaW5lIHdhdGVyIn0seyJpZCI6IlEzOTcxNSIsIm5hbWUiOiJsaWdodGhvdXNlIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUgZGVzaWduZWQgdG8gZW1pdCBsaWdodCB0byBhaWQgbmF2aWdhdGlvbiJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjE1NjI3IiwibmFtZSI6InBlcnNvbiIsImRlc2NyaXB0aW9uIjoiYmVpbmcgdGhhdCBoYXMgY2VydGFpbiBjYXBhY2l0aWVzIG9yIGF0dHJpYnV0ZXMgY29uc3RpdHV0aW5nIHBlcnNvbmhvb2QgKGF2b2lkIHVzZSB3aXRoIFAzMTsgdXNlIFE1IGZvciBodW1hbnMpIn0seyJpZCI6IlExMzQ1MDI4MyIsIm5hbWUiOiJ3ZXRzdWl0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB3YXRlciBhY3Rpdml0aWVzLCBwcm92aWRpbmcgdGhlcm1hbCBpbnN1bGF0aW9uIGJ1dCBub3QgZGVzaWduZWQgdG8gcHJldmVudCB3YXRlciBlbnRlcmluZyJ9LHsiaWQiOiJRMTEwMjIiLCJuYW1lIjoic2NyZXciLCJkZXNjcmlwdGlvbiI6InR5cGUgb2YgZmFzdGVuZXIgY2hhcmFjdGVyaXplZCBieSBhIHRocmVhZCB3cmFwcGVkIGFyb3VuZCBhIGN5bGluZGVyIn0seyJpZCI6IlEzOTU0NiIsIm5hbWUiOiJ0b29sIiwiZGVzY3JpcHRpb24iOiJwaHlzaWNhbCBpdGVtIHRoYXQgY2FuIGJlIHVzZWQgdG8gYWNoaWV2ZSBhIGdvYWwifSx7ImlkIjoiUTMyNDg5IiwibmFtZSI6ImtuaWZlIiwiZGVzY3JpcHRpb24iOiJ0b29sIHdpdGggYSBjdXR0aW5nIGVkZ2Ugb3IgYmxhZGUifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzk1NDYiLCJuYW1lIjoidG9vbCIsImRlc2NyaXB0aW9uIjoicGh5c2ljYWwgaXRlbSB0aGF0IGNhbiBiZSB1c2VkIHRvIGFjaGlldmUgYSBnb2FsIn0seyJpZCI6IlEyMDIwNDE1MSIsIm5hbWUiOiJob2xlIiwiZGVzY3JpcHRpb24iOiJvcGVuaW5nIGluIHRoZSBzdXJmYWNlIG9mIGFuIG9iamVjdCJ9LHsiaWQiOiJRMjg3IiwibmFtZSI6Indvb2QiLCJkZXNjcmlwdGlvbiI6ImZpYnJvdXMgbWF0ZXJpYWwgZnJvbSB0cmVlcyBvciBvdGhlciBwbGFudHMifSx7ImlkIjoiUTIxNTYyNyIsIm5hbWUiOiJwZXJzb24iLCJkZXNjcmlwdGlvbiI6ImJlaW5nIHRoYXQgaGFzIGNlcnRhaW4gY2FwYWNpdGllcyBvciBhdHRyaWJ1dGVzIGNvbnN0aXR1dGluZyBwZXJzb25ob29kIChhdm9pZCB1c2Ugd2l0aCBQMzE7IHVzZSBRNSBmb3IgaHVtYW5zKSJ9LHsiaWQiOiJRMzM3NjciLCJuYW1lIjoiaGFuZCIsImRlc2NyaXB0aW9uIjoiZXh0cmVtaXR5IGF0IHRoZSBlbmQgb2YgYW4gYXJtIG9yIGZvcmVsaW1iIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTc3MDkyNzkiLCJuYW1lIjoiYXR0YWNobWVudCIsImRlc2NyaXB0aW9uIjoiZGlnaXRhbCBvciBwaHlzaWNhbCBkb2N1bWVudCBvciBvdGhlciB3b3JrIHdoaWNoIGlzIGF0dGFjaGVkIHRvLCBidXQgbm90IHRyYW5zY2x1ZGVkIGluLCBhbm90aGVyIHdvcmsifSx7ImlkIjoiUTI4NzI1NTMiLCJuYW1lIjoic3RpY2tlciIsImRlc2NyaXB0aW9uIjoiYSB0eXBlIG9mIGxhYmVsOiBhIHBpZWNlIG9mIHByaW50ZWQgcGFwZXIsIHBsYXN0aWMsIG9yIG90aGVyIG1hdGVyaWFsIHdpdGggcHJlc3N1cmUgc2Vuc2l0aXZlIGFkaGVzaXZlIG9uIG9uZSBzaWRlIn0seyJpZCI6IlEyMTU2MjciLCJuYW1lIjoicGVyc29uIiwiZGVzY3JpcHRpb24iOiJiZWluZyB0aGF0IGhhcyBjZXJ0YWluIGNhcGFjaXRpZXMgb3IgYXR0cmlidXRlcyBjb25zdGl0dXRpbmcgcGVyc29uaG9vZCAoYXZvaWQgdXNlIHdpdGggUDMxOyB1c2UgUTUgZm9yIGh1bWFucykifSx7ImlkIjoiUTMxNDIiLCJuYW1lIjoicmVkIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRMzM3NjciLCJuYW1lIjoiaGFuZCIsImRlc2NyaXB0aW9uIjoiZXh0cmVtaXR5IGF0IHRoZSBlbmQgb2YgYW4gYXJtIG9yIGZvcmVsaW1iIn1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask16(
    override val poolId: String = "16",
    override val result: Result = Result("v_00234", 106f, 123f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDExNzYiLCJuYW1lIjoiYnVpbGRpbmciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZSwgdHlwaWNhbGx5IHdpdGggYSByb29mIGFuZCB3YWxscywgc3RhbmRpbmcgbW9yZSBvciBsZXNzIHBlcm1hbmVudGx5IGluIG9uZSBwbGFjZSJ9LHsiaWQiOiJRMTc5NzAwIiwibmFtZSI6InN0YXR1ZSIsImRlc2NyaXB0aW9uIjoic2N1bHB0dXJlIHByaW1hcmlseSBjb25jZWl2ZWQgYXMgYSByZXByZXNlbnRhdGlvbmFsIGZpZ3VyZSJ9LHsiaWQiOiJRODA3NCIsIm5hbWUiOiJjbG91ZCIsImRlc2NyaXB0aW9uIjoidmlzaWJsZSBtYXNzIG9mIGxpcXVpZCBkcm9wbGV0cyBvciBmcm96ZW4gY3J5c3RhbHMgc3VzcGVuZGVkIGluIHRoZSBhdG1vc3BoZXJlIn0seyJpZCI6IlE1MjciLCJuYW1lIjoic2t5IiwiZGVzY3JpcHRpb24iOiJldmVyeXRoaW5nIHRoYXQgaXMgYWJvdmUgdGhlIHN1cmZhY2Ugb2YgdGhlIEVhcnRoIn0seyJpZCI6IlEyNzkzOSIsIm5hbWUiOiJzaW5naW5nIiwiZGVzY3JpcHRpb24iOiJhY3Qgb2YgcHJvZHVjaW5nIG11c2ljYWwgc291bmRzIHdpdGggdGhlIHZvaWNlIn1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzk1OTQiLCJuYW1lIjoiYmF5IiwiZGVzY3JpcHRpb24iOiJib2R5IG9mIHdhdGVyIGNvbm5lY3RlZCB0byBhbiBvY2VhbiBvciBsYWtlLCBmb3JtZWQgYnkgYW4gaW5kZW50YXRpb24gb2YgdGhlIHNob3JlbGluZSJ9LHsiaWQiOiJROTQ2NDk5IiwibmFtZSI6ImNydWlzZSBsaW5lIiwiZGVzY3JpcHRpb24iOiJjb21wYW55IHRoYXQgb3BlcmF0ZXMgY3J1aXNlIHNoaXBzIn0seyJpZCI6IlEzOTgwNCIsIm5hbWUiOiJjcnVpc2Ugc2hpcCIsImRlc2NyaXB0aW9uIjoicGFzc2VuZ2VyIHNoaXAgdXNlZCBmb3IgcGxlYXN1cmUgdm95YWdlcyJ9LHsiaWQiOiJRMjgzIiwibmFtZSI6IndhdGVyIiwiZGVzY3JpcHRpb24iOiJjaGVtaWNhbCBjb21wb3VuZDsgbWFpbiBjb25zdGl0dWVudCBvZiB0aGUgZmx1aWRzIG9mIG1vc3QgbGl2aW5nIG9yZ2FuaXNtcyJ9LHsiaWQiOiJRNjEyODUiLCJuYW1lIjoidWt1bGVsZSIsImRlc2NyaXB0aW9uIjoibWVtYmVyIG9mIHRoZSBndWl0YXIgZmFtaWx5In1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTA2IiwibmFtZSI6ImZsb3dlciIsImRlc2NyaXB0aW9uIjoic2V4dWFsIHJlcHJvZHVjdGl2ZSBzdHJ1Y3R1cmUgZm91bmQgaW4gZmxvd2VyaW5nIHBsYW50cyJ9LHsiaWQiOiJRMzE0MiIsIm5hbWUiOiJyZWQiLCJkZXNjcmlwdGlvbiI6ImNvbG9yIn0seyJpZCI6IlEzMTMzIiwibmFtZSI6ImdyZWVuIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgcHJpbWFyeSBjb2xvcjsgdmlzaWJsZSBiZXR3ZWVuIGJsdWUgYW5kIHllbGxvdyJ9LHsiaWQiOiJRNzU2IiwibmFtZSI6InBsYW50IiwiZGVzY3JpcHRpb24iOiJtdWx0aWNlbGx1bGFyIGV1a2FyeW90ZSBvZiB0aGUga2luZ2RvbSBQbGFudGFlIn0seyJpZCI6IlEzMzk3MSIsIm5hbWUiOiJsZWFmIiwiZGVzY3JpcHRpb24iOiJtYWluIG9yZ2FuIG9mIHBob3Rvc3ludGhlc2lzIGFuZCB0cmFuc3BpcmF0aW9uIGluIGhpZ2hlciBwbGFudHMsIHVzdWFsbHkgY29uc2lzdGluZyBvZiBhIGZsYXQgZ3JlZW4gYmxhZGUgYXR0YWNoZWQgdG8gdGhlIHN0ZW0gZGlyZWN0bHkgb3IgYnkgYSBzdGFsayJ9LHsiaWQiOiJRNjEyODUiLCJuYW1lIjoidWt1bGVsZSIsImRlc2NyaXB0aW9uIjoibWVtYmVyIG9mIHRoZSBndWl0YXIgZmFtaWx5In1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDAwODAiLCJuYW1lIjoiYmVhY2giLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2Ygc2FuZCBvciBzbWFsbCBzdG9uZXMgbmVhciB0aGUgc2VhIG9yIGFub3RoZXIgYXJlYSBvZiB3YXRlciBzdWNoIGFzIGEgbGFrZSJ9LHsiaWQiOiJRMzQ2NzkiLCJuYW1lIjoic2FuZCIsImRlc2NyaXB0aW9uIjoiZ3JhbnVsYXIgbWF0ZXJpYWwgY29tcG9zZWQgb2YgZmluZWx5IGRpdmlkZWQgcm9jayBhbmQgbWluZXJhbCBwYXJ0aWNsZXMsIHNhbmQgcGFydGljbGVzIHJhbmdlIGluIGRpYW1ldGVyIGZyb20gMC4wNjMgdG8gMiBtbSAocGVyIElTTyAxNDY4OCkifSx7ImlkIjoiUTYxMjg1IiwibmFtZSI6InVrdWxlbGUiLCJkZXNjcmlwdGlvbiI6Im1lbWJlciBvZiB0aGUgZ3VpdGFyIGZhbWlseSJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask17(
    override val poolId: String = "17",
    override val result: Result = Result("v_05991", 167f, 205f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjQ3MjU4NyIsIm5hbWUiOiJwZW9wbGUiLCJkZXNjcmlwdGlvbiI6InBsdXJhbGl0eSBvZiBwZXJzb25zIGNvbnNpZGVyZWQgYXMgYSB3aG9sZSwgZnJvbSBhIGdvdmVybm1lbnQgcGVyc3BlY3RpdmUifSx7ImlkIjoiUTQzMTkzIiwibmFtZSI6InRydWNrIiwiZGVzY3JpcHRpb24iOiJmcmVpZ2h0IG1vdG9yIHZlaGljbGUifSx7ImlkIjoiUTEzNjQiLCJuYW1lIjoiZnJ1aXQiLCJkZXNjcmlwdGlvbiI6InBhcnQgb2YgYSBmbG93ZXJpbmcgcGxhbnQifV0="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODI2NTAiLCJuYW1lIjoidGF4aSIsImRlc2NyaXB0aW9uIjoidHlwZSBvZiB2ZWhpY2xlIGZvciBoaXJlIHdpdGggYSBkcml2ZXIifSx7ImlkIjoiUTM1MjM4OCIsIm5hbWUiOiJkcml2ZXIiLCJkZXNjcmlwdGlvbiI6Im9jY3VwYXRpb24sIG9wZXJhdG9yIG9mIG1vdG9yaXplZCBncm91bmQgdmVoaWNsZXMifSx7ImlkIjoiUTQyODg5IiwibmFtZSI6InZlaGljbGUiLCJkZXNjcmlwdGlvbiI6Im1vYmlsZSBtYWNoaW5lIHRoYXQgdHJhbnNwb3J0cyBwZW9wbGUsIGFuaW1hbHMgb3IgY2FyZ28ifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODI2NTAiLCJuYW1lIjoidGF4aSIsImRlc2NyaXB0aW9uIjoidHlwZSBvZiB2ZWhpY2xlIGZvciBoaXJlIHdpdGggYSBkcml2ZXIifSx7ImlkIjoiUTIzODA1MyIsIm5hbWUiOiJjb2xsaXNpb24iLCJkZXNjcmlwdGlvbiI6ImV2ZW50IGluIHdoaWNoIHR3byBvciBtb3JlIGJvZGllcyBleGVydCBmb3JjZXMgb24gZWFjaCBvdGhlciBmb3IgYSByZWxhdGl2ZWx5IHNob3J0IHRpbWUifSx7ImlkIjoiUTQzMTkzIiwibmFtZSI6InRydWNrIiwiZGVzY3JpcHRpb24iOiJmcmVpZ2h0IG1vdG9yIHZlaGljbGUifSx7ImlkIjoiUTEzNjQiLCJuYW1lIjoiZnJ1aXQiLCJkZXNjcmlwdGlvbiI6InBhcnQgb2YgYSBmbG93ZXJpbmcgcGxhbnQifSx7ImlkIjoiUTI0NzI1ODciLCJuYW1lIjoicGVvcGxlIiwiZGVzY3JpcHRpb24iOiJwbHVyYWxpdHkgb2YgcGVyc29ucyBjb25zaWRlcmVkIGFzIGEgd2hvbGUsIGZyb20gYSBnb3Zlcm5tZW50IHBlcnNwZWN0aXZlIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTEzNzY1NSIsIm5hbWUiOiJpbnNwZWN0aW9uIiwiZGVzY3JpcHRpb24iOiJvcmdhbml6ZWQgZXhhbWluYXRpb24gb3IgZm9ybWFsIGV2YWx1YXRpb24gZXhlcmNpc2UifSx7ImlkIjoiUTgyNjUwIiwibmFtZSI6InRheGkiLCJkZXNjcmlwdGlvbiI6InR5cGUgb2YgdmVoaWNsZSBmb3IgaGlyZSB3aXRoIGEgZHJpdmVyIn0seyJpZCI6IlE0MzE5MyIsIm5hbWUiOiJ0cnVjayIsImRlc2NyaXB0aW9uIjoiZnJlaWdodCBtb3RvciB2ZWhpY2xlIn0seyJpZCI6IlEzNDQ0MiIsIm5hbWUiOiJyb2FkIiwiZGVzY3JpcHRpb24iOiJ3YXkgb24gbGFuZCBiZXR3ZWVuIHR3byBwbGFjZXMifSx7ImlkIjoiUTIxMjUxNTYiLCJuYW1lIjoiYmxvY2siLCJkZXNjcmlwdGlvbiI6ImEgcmVzdHJpY3Rpb24gb24gYWNjZXNzaW5nIGFuIG9ubGluZSByZXNvdXJjZSwgZW5mb3JjZWQgdGhyb3VnaCB0ZWNobmljYWwgbWVhbnMifSx7ImlkIjoiUTIwNDAyOCIsIm5hbWUiOiJzdWJ0aXRsZSIsImRlc2NyaXB0aW9uIjoidGV4dHVhbCByZXByZXNlbnRhdGlvbiBvZiBldmVudHMgYW5kIHNwZWVjaCBpbiBtb3Rpb24gaW1hZ2VyeSJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask18(
    override val poolId: String = "18",
    override val result: Result = Result("v_04194", 51f, 79f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMTE0NDU5MyIsIm5hbWUiOiJzaXR0aW5nIiwiZGVzY3JpcHRpb24iOiJodW1hbiByZXN0aW5nIHBvc2l0aW9uOyBib2R5IHdlaWdodCBpcyBzdXBwb3J0ZWQgcHJpbWFyaWx5IGJ5IHRoZSBidXR0b2NrcyBpbiBjb250YWN0IHdpdGggdGhlIGdyb3VuZCBvciBhIGhvcml6b250YWwgb2JqZWN0IHN1Y2ggYXMgYSBjaGFpciJ9LHsiaWQiOiJRMTY5MTciLCJuYW1lIjoiaG9zcGl0YWwiLCJkZXNjcmlwdGlvbiI6ImhlYWx0aCBjYXJlIGZhY2lsaXR5IChmb3Igb3JnYW5pemF0aW9ucyB1c2UgIG1lZGljYWwgb3JnYW5pemF0aW9uIChRNDI4Nzc0NSksIGZvciBpbmRpdmlkdWFsIGJ1aWxkaW5ncyB1c2UgUTM5MzY0NzIzKSJ9LHsiaWQiOiJRMzE0MDk3MSIsIm5hbWUiOiJob3NwaXRhbGl6YXRpb24iLCJkZXNjcmlwdGlvbiI6ImFkbWlzc2lvbiBvZiBhIHBhdGllbnQgdG8gYSBob3NwaXRhbCJ9LHsiaWQiOiJRNjU1NDEwMSIsIm5hbWUiOiJtZWRpY2FsIGRldmljZSIsImRlc2NyaXB0aW9uIjoiYW55IGluc3RydW1lbnQsIGFwcGFyYXR1cywgaW1wbGFudCwgaW4gdml0cm8gcmVhZ2VudCwgb3Igc2ltaWxhciBvciByZWxhdGVkIGFydGljbGUgdXNlZCBmb3IgZGlhZ25vc3RpYyBhbmQvb3IgdGhlcmFwZXV0aWMgcHVycG9zZXMifSx7ImlkIjoiUTI2Mzc4MTQiLCJuYW1lIjoicmFjayBvZiBzaGVsdmVzIiwiZGVzY3JpcHRpb24iOiJzZXQgb2Ygc2hlbHZlcywgY29tYmluZWQgaW50byBvbmUgcGllY2Ugb2YgZnVybml0dXJlIn1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTUwMjYiLCJuYW1lIjoiY2hhaXIiLCJkZXNjcmlwdGlvbiI6InBpZWNlIG9mIGZ1cm5pdHVyZSBmb3Igc2l0dGluZyBvbiJ9LHsiaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDQ1OTMiLCJuYW1lIjoic2l0dGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcmVzdGluZyBwb3NpdGlvbjsgYm9keSB3ZWlnaHQgaXMgc3VwcG9ydGVkIHByaW1hcmlseSBieSB0aGUgYnV0dG9ja3MgaW4gY29udGFjdCB3aXRoIHRoZSBncm91bmQgb3IgYSBob3Jpem9udGFsIG9iamVjdCBzdWNoIGFzIGEgY2hhaXIifSx7ImlkIjoiUTE5ODYwOTgiLCJuYW1lIjoic3RhbmRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHBvc2l0aW9uIGluIHdoaWNoIHRoZSBib2R5IGlzIGhlbGQgaW4gYW4gdXByaWdodCBwb3NpdGlvbiJ9LHsiaWQiOiJRNjU1NDEwMSIsIm5hbWUiOiJtZWRpY2FsIGRldmljZSIsImRlc2NyaXB0aW9uIjoiYW55IGluc3RydW1lbnQsIGFwcGFyYXR1cywgaW1wbGFudCwgaW4gdml0cm8gcmVhZ2VudCwgb3Igc2ltaWxhciBvciByZWxhdGVkIGFydGljbGUgdXNlZCBmb3IgZGlhZ25vc3RpYyBhbmQvb3IgdGhlcmFwZXV0aWMgcHVycG9zZXMifSx7ImlkIjoiUTE2OTE3IiwibmFtZSI6Imhvc3BpdGFsIiwiZGVzY3JpcHRpb24iOiJoZWFsdGggY2FyZSBmYWNpbGl0eSAoZm9yIG9yZ2FuaXphdGlvbnMgdXNlICBtZWRpY2FsIG9yZ2FuaXphdGlvbiAoUTQyODc3NDUpLCBmb3IgaW5kaXZpZHVhbCBidWlsZGluZ3MgdXNlIFEzOTM2NDcyMykifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTUxMjE3MDgiLCJuYW1lIjoiY2lyY3VsYXRvcnkgY29sbGFwc2UiLCJkZXNjcmlwdGlvbiI6ImZhaWx1cmUgb2YgY2lyY3VsYXRpb24sIHN1Y2ggYXMgYmxvb2QgZmxvdyJ9LHsiaWQiOiJRMjI2ODc3NiIsIm5hbWUiOiJseWluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcG9zaXRpb24gaW4gd2hpY2ggdGhlIGJvZHkgaXMgbW9yZSBvciBsZXNzIGhvcml6b250YWwgYW5kIHN1cHBvcnRlZCBhbG9uZyBpdHMgbGVuZ3RoIGJ5IHRoZSBzdXJmYWNlIHVuZGVybmVhdGgifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMTY5MTciLCJuYW1lIjoiaG9zcGl0YWwiLCJkZXNjcmlwdGlvbiI6ImhlYWx0aCBjYXJlIGZhY2lsaXR5IChmb3Igb3JnYW5pemF0aW9ucyB1c2UgIG1lZGljYWwgb3JnYW5pemF0aW9uIChRNDI4Nzc0NSksIGZvciBpbmRpdmlkdWFsIGJ1aWxkaW5ncyB1c2UgUTM5MzY0NzIzKSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE0MTE3MjUiLCJuYW1lIjoiY3Jhd2xpbmciLCJkZXNjcmlwdGlvbiI6Im1vdmluZyBhbG9uZyB0aGUgZ3JvdW5kIG9uIGhhbmRzIGFuZCBrbmVlcyJ9LHsiaWQiOiJRMjE3MTY0IiwibmFtZSI6ImZsb29yIiwiZGVzY3JpcHRpb24iOiJ3YWxraW5nIHN1cmZhY2Ugb2YgYSByb29tIn0seyJpZCI6IlEyMzQ0NSIsIm5hbWUiOiJibGFjayIsImRlc2NyaXB0aW9uIjoiZGFya2VzdCBjb2xvciwgcmVzdWx0aW5nIGZyb20gdGhlIGFic2VuY2Ugb3IgY29tcGxldGUgYWJzb3JwdGlvbiBvZiBsaWdodC4gTGlrZSB3aGl0ZSBhbmQgZ3JleSwgaXQgaXMgYW4gYWNocm9tYXRpYyBjb2xvciwgbGl0ZXJhbGx5IGEgY29sb3Igd2l0aG91dCBodWUifSx7ImlkIjoiUTU4NDAxMyIsIm5hbWUiOiJGYWRlYXdheSIsImRlc2NyaXB0aW9uIjoiIn0seyJpZCI6IlExNjkxNyIsIm5hbWUiOiJob3NwaXRhbCIsImRlc2NyaXB0aW9uIjoiaGVhbHRoIGNhcmUgZmFjaWxpdHkgKGZvciBvcmdhbml6YXRpb25zIHVzZSAgbWVkaWNhbCBvcmdhbml6YXRpb24gKFE0Mjg3NzQ1KSwgZm9yIGluZGl2aWR1YWwgYnVpbGRpbmdzIHVzZSBRMzkzNjQ3MjMpIn1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask19(
    override val poolId: String = "19",
    override val result: Result = Result("v_02745", 977f, 999f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNjY0Mjk3NjAiLCJuYW1lIjoiZ3Jhc3MiLCJkZXNjcmlwdGlvbiI6Im1hdGVyaWFsIGNvbXByaXNpbmcgdGhlIHN0YWxrcyBvciBsZWF2ZXMgb2YgcGxhbnRzIG9mIHRoZSBmYW1pbHkgUG9hY2VhZSwgYW5kIHBsYW50cyByZXNlbWJsaW5nIHRoZXNlIGluIGdlbmVyYWwgYXBwZWFyYW5jZSJ9LHsiaWQiOiJRMTg4ODY5IiwibmFtZSI6ImZpZWxkIiwiZGVzY3JpcHRpb24iOiJhcmVhIG9mIGxhbmQgdXNlZCBmb3IgYWdyaWN1bHR1cmFsIHB1cnBvc2VzIn0seyJpZCI6IlE0MTE3NiIsIm5hbWUiOiJidWlsZGluZyIsImRlc2NyaXB0aW9uIjoic3RydWN0dXJlLCB0eXBpY2FsbHkgd2l0aCBhIHJvb2YgYW5kIHdhbGxzLCBzdGFuZGluZyBtb3JlIG9yIGxlc3MgcGVybWFuZW50bHkgaW4gb25lIHBsYWNlIn0seyJpZCI6IlEzMTQyIiwibmFtZSI6InJlZCIsImRlc2NyaXB0aW9uIjoiY29sb3IifSx7ImlkIjoiUTIzNDQ0IiwibmFtZSI6IndoaXRlIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRODMxODAiLCJuYW1lIjoicm9vZiIsImRlc2NyaXB0aW9uIjoidG9wIGNvdmVyaW5nIG9mIGEgYnVpbGRpbmcifV0="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDExNzYiLCJuYW1lIjoiYnVpbGRpbmciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZSwgdHlwaWNhbGx5IHdpdGggYSByb29mIGFuZCB3YWxscywgc3RhbmRpbmcgbW9yZSBvciBsZXNzIHBlcm1hbmVudGx5IGluIG9uZSBwbGFjZSJ9LHsiaWQiOiJRMTg3OTk3IiwibmFtZSI6InZlZ2V0YXRpb24iLCJkZXNjcmlwdGlvbiI6InRvdGFsIG9mIHBsYW50IGZvcm1hdGlvbnMgYW5kIHBsYW50IGNvbW11bml0aWVzIn0seyJpZCI6IlExNzE1NjQ1NSIsIm5hbWUiOiJ5b3VuZyBhZHVsdCIsImRlc2NyaXB0aW9uIjoicGVyc29uIGluIHRoZSBhZ2UgcmFuZ2Ugb2YgMjAgdG8gNDAifSx7ImlkIjoiUTI0NzI1ODciLCJuYW1lIjoicGVvcGxlIiwiZGVzY3JpcHRpb24iOiJwbHVyYWxpdHkgb2YgcGVyc29ucyBjb25zaWRlcmVkIGFzIGEgd2hvbGUsIGZyb20gYSBnb3Zlcm5tZW50IHBlcnNwZWN0aXZlIn0seyJpZCI6IlE2NTM3Mzc5IiwibmFtZSI6IndhbGtpbmciLCJkZXNjcmlwdGlvbiI6Im9uZSBvZiB0aGUgbWFpbiBnYWl0cyBvZiBsb2NvbW90aW9uIGFtb25nIGxlZ2dlZCBhbmltYWxzLCB0eXBpY2FsbHkgc2xvd2VyIHRoYW4gcnVubmluZyBhbmQgb3RoZXIgZ2FpdHM7IGNoYXJhY3Rlcml6ZWQgYnkgYSAndmF1bHRpbmcnIG1vdmVtZW50IG9mIHRoZSBib2R5IG92ZXIgdGhlIGxlZ3MsIGZyZXF1ZW50bHkgZGVzY3JpYmVkIGFzIGFuIGludmVydGVkIHBlbmR1bHVtIn0seyJpZCI6IlEyMzQ0NCIsIm5hbWUiOiJ3aGl0ZSIsImRlc2NyaXB0aW9uIjoiY29sb3IifSx7ImlkIjoiUTc2NzY4IiwibmFtZSI6InNoaXJ0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB0aGUgdXBwZXIgYm9keSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzU2OSIsIm5hbWUiOiJjaGlsZCIsImRlc2NyaXB0aW9uIjoiaHVtYW4gYmV0d2VlbiB0aGUgc3RhZ2VzIG9mIGJpcnRoIGFuZCBwdWJlcnR5In0seyJpZCI6IlEyNDcyNTg3IiwibmFtZSI6InBlb3BsZSIsImRlc2NyaXB0aW9uIjoicGx1cmFsaXR5IG9mIHBlcnNvbnMgY29uc2lkZXJlZCBhcyBhIHdob2xlLCBmcm9tIGEgZ292ZXJubWVudCBwZXJzcGVjdGl2ZSJ9LHsiaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlEyMzQ0NCIsIm5hbWUiOiJ3aGl0ZSIsImRlc2NyaXB0aW9uIjoiY29sb3IifSx7ImlkIjoiUTIzNDQ1IiwibmFtZSI6ImJsYWNrIiwiZGVzY3JpcHRpb24iOiJkYXJrZXN0IGNvbG9yLCByZXN1bHRpbmcgZnJvbSB0aGUgYWJzZW5jZSBvciBjb21wbGV0ZSBhYnNvcnB0aW9uIG9mIGxpZ2h0LiBMaWtlIHdoaXRlIGFuZCBncmV5LCBpdCBpcyBhbiBhY2hyb21hdGljIGNvbG9yLCBsaXRlcmFsbHkgYSBjb2xvciB3aXRob3V0IGh1ZSJ9LHsiaWQiOiJROTY4OTA3IiwibmFtZSI6Im91dGRvb3IgcmVjcmVhdGlvbiIsImRlc2NyaXB0aW9uIjoiIn0seyJpZCI6IlExMTQ0MiIsIm5hbWUiOiJiaWN5Y2xlIiwiZGVzY3JpcHRpb24iOiJwZWRhbC1kcml2ZW4gdHdvLXdoZWVsIHZlaGljbGUifSx7ImlkIjoiUTQyOTQ4IiwibmFtZSI6IndhbGwiLCJkZXNjcmlwdGlvbiI6InZlcnRpY2FsIHN0cnVjdHVyZSwgdXN1YWxseSBzb2xpZCwgdGhhdCBkZWZpbmVzIGFuZCBzb21ldGltZXMgcHJvdGVjdHMgYW4gYXJlYSJ9LHsiaWQiOiJRNDExNzYiLCJuYW1lIjoiYnVpbGRpbmciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZSwgdHlwaWNhbGx5IHdpdGggYSByb29mIGFuZCB3YWxscywgc3RhbmRpbmcgbW9yZSBvciBsZXNzIHBlcm1hbmVudGx5IGluIG9uZSBwbGFjZSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNzU2OSIsIm5hbWUiOiJjaGlsZCIsImRlc2NyaXB0aW9uIjoiaHVtYW4gYmV0d2VlbiB0aGUgc3RhZ2VzIG9mIGJpcnRoIGFuZCBwdWJlcnR5In0seyJpZCI6IlEyNDcyNTg3IiwibmFtZSI6InBlb3BsZSIsImRlc2NyaXB0aW9uIjoicGx1cmFsaXR5IG9mIHBlcnNvbnMgY29uc2lkZXJlZCBhcyBhIHdob2xlLCBmcm9tIGEgZ292ZXJubWVudCBwZXJzcGVjdGl2ZSJ9LHsiaWQiOiJRMzMwMDU3NjAiLCJuYW1lIjoibmFycmF0aW9uIiwiZGVzY3JpcHRpb24iOiJ1c2Ugb2YgYSB3cml0dGVuIG9yIHNwb2tlbiBjb21tZW50YXJ5IHRvIGNvbnZleSBhIHN0b3J5IHRvIGFuIGF1ZGllbmNlIn0seyJpZCI6IlEyMDQwMjgiLCJuYW1lIjoic3VidGl0bGUiLCJkZXNjcmlwdGlvbiI6InRleHR1YWwgcmVwcmVzZW50YXRpb24gb2YgZXZlbnRzIGFuZCBzcGVlY2ggaW4gbW90aW9uIGltYWdlcnkifSx7ImlkIjoiUTE1MCIsIm5hbWUiOiJGcmVuY2giLCJkZXNjcmlwdGlvbiI6IlJvbWFuY2UgbGFuZ3VhZ2Ugb2YgdGhlIEluZG8tRXVyb3BlYW4gZmFtaWx5In0seyJpZCI6IlExMTc0ODM3OCIsIm5hbWUiOiJjb3ciLCJkZXNjcmlwdGlvbiI6ImZlbWFsZSBjYXR0bGUifSx7ImlkIjoiUTM5MTQiLCJuYW1lIjoic2Nob29sIiwiZGVzY3JpcHRpb24iOiJpbnN0aXR1dGlvbiBkZXNpZ25lZCB0byB0ZWFjaCBzdHVkZW50cyB1bmRlciB0aGUgZGlyZWN0aW9uIG9mIHNjaG9vbCB0ZWFjaGVyIn1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask20(
    override val poolId: String = "20",
    override val result: Result = Result("v_02756", 230f, 280f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTI4MjMxMDUiLCJuYW1lIjoib2ZmaWNlIiwiZGVzY3JpcHRpb24iOiJyb29tIHdoZXJlIHBlb3BsZSBwZXJmb3JtIHRoZWlyIGR1dGllcyJ9LHsiaWQiOiJRMjM2NzEwMSIsIm5hbWUiOiJicm93biBoYWlyIiwiZGVzY3JpcHRpb24iOiJodW1hbiBoYWlyIGNvbG9yIn0seyJpZCI6IlExMDg4IiwibmFtZSI6ImJsdWUiLCJkZXNjcmlwdGlvbiI6ImNvbG9yOyBhZGRpdGl2ZSBhbmQgc3VidHJhY3RpdmUgKFJZQikgcHJpbWFyeSBjb2xvcjsgdmlzaWJsZSBiZXR3ZWVuIHB1cnBsZSBhbmQgZ3JlZW4ifSx7ImlkIjoiUTIzMjE5MSIsIm5hbWUiOiJzd2VhdGVyIiwiZGVzY3JpcHRpb24iOiJrbml0dGVkIGdhcm1lbnQgZnJvbSB0aGUgdXBwZXIgYm9keSJ9LHsiaWQiOiJRMjM0NDQiLCJuYW1lIjoid2hpdGUiLCJkZXNjcmlwdGlvbiI6ImNvbG9yIn0seyJpZCI6IlE3Njc2OCIsIm5hbWUiOiJzaGlydCIsImRlc2NyaXB0aW9uIjoiZ2FybWVudCBmb3IgdGhlIHVwcGVyIGJvZHkifSx7ImlkIjoiUTQ2NyIsIm5hbWUiOiJ3b21hbiIsImRlc2NyaXB0aW9uIjoiZmVtYWxlIGFkdWx0IGh1bWFuIn0seyJpZCI6IlEyMDI0NjYiLCJuYW1lIjoiYmxvbmQgaGFpciIsImRlc2NyaXB0aW9uIjoiaGFpciBjb2xvciJ9LHsiaWQiOiJRMjg1MDM3NTEiLCJuYW1lIjoic3BlYWtlciIsImRlc2NyaXB0aW9uIjoicGVyc29uIGNhcGFibGUgb2YgdmVyYmFsIGNvbW11bmljYXRpb24ifSx7ImlkIjoiUTEyODk2MTA1IiwibmFtZSI6Imx1bmNoIiwiZGVzY3JpcHRpb24iOiJtZWFsLCB1c3VhbGx5IHNlcnZlZCBhdCBtaWRkYXkifV0="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTI4MjMxMDUiLCJuYW1lIjoib2ZmaWNlIiwiZGVzY3JpcHRpb24iOiJyb29tIHdoZXJlIHBlb3BsZSBwZXJmb3JtIHRoZWlyIGR1dGllcyJ9LHsiaWQiOiJRMjA5NSIsIm5hbWUiOiJmb29kIiwiZGVzY3JpcHRpb24iOiJhbnkgc3Vic3RhbmNlIGNvbnN1bWVkIHRvIHByb3ZpZGUgbnV0cml0aW9uYWwgc3VwcG9ydCBmb3IgdGhlIGJvZHk7IGZvcm0gb2YgZW5lcmd5IHN0b3JlZCBpbiBjaGVtaWNhbCJ9LHsiaWQiOiJRNTY2ODg5IiwibmFtZSI6Im9yZGVyIiwiZGVzY3JpcHRpb24iOiJzdGF0ZWQgaW50ZW50aW9uIHRvIGVuZ2FnZSBpbiBhIGNvbW1lcmNpYWwgdHJhbnNhY3Rpb24gZm9yIHNwZWNpZmljIHByb2R1Y3RzIG9yIHNlcnZpY2VzIn0seyJpZCI6IlE0NjciLCJuYW1lIjoid29tYW4iLCJkZXNjcmlwdGlvbiI6ImZlbWFsZSBhZHVsdCBodW1hbiJ9LHsiaWQiOiJRNjY3NDc4IiwibmFtZSI6ImNoZWVzZWJ1cmdlciIsImRlc2NyaXB0aW9uIjoiaGFtYnVyZ2VyIHRvcHBlZCB3aXRoIGNoZWVzZSJ9LHsiaWQiOiJRNjY2MyIsIm5hbWUiOiJoYW1idXJnZXIiLCJkZXNjcmlwdGlvbiI6InNhbmR3aWNoIGNvbnNpc3Rpbmcgb2Ygb25lIG9yIG1vcmUgY29va2VkIHBhdHRpZXMgb2YgZ3JvdW5kIG1lYXQsIHVzdWFsbHkgYmVlZiwgcGxhY2VkIGluc2lkZSBhIHNsaWNlZCBicmVhZCByb2xsIG9yIGJ1biJ9LHsiaWQiOiJRMTMyOTAiLCJuYW1lIjoic21vb3RoaWUiLCJkZXNjcmlwdGlvbiI6ImRyaW5rIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTM5MzM4IiwibmFtZSI6Im9yYW5nZSIsImRlc2NyaXB0aW9uIjoiY29sb3IsIGxvY2F0ZWQgYmV0d2VlbiByZWQgYW5kIHllbGxvdyBpbiB0aGUgc3BlY3RydW0gb2YgbGlnaHQifSx7ImlkIjoiUTc2NzY4IiwibmFtZSI6InNoaXJ0IiwiZGVzY3JpcHRpb24iOiJnYXJtZW50IGZvciB0aGUgdXBwZXIgYm9keSJ9LHsiaWQiOiJRMTI4MjMxMDUiLCJuYW1lIjoib2ZmaWNlIiwiZGVzY3JpcHRpb24iOiJyb29tIHdoZXJlIHBlb3BsZSBwZXJmb3JtIHRoZWlyIGR1dGllcyJ9LHsiaWQiOiJRMjA5NSIsIm5hbWUiOiJmb29kIiwiZGVzY3JpcHRpb24iOiJhbnkgc3Vic3RhbmNlIGNvbnN1bWVkIHRvIHByb3ZpZGUgbnV0cml0aW9uYWwgc3VwcG9ydCBmb3IgdGhlIGJvZHk7IGZvcm0gb2YgZW5lcmd5IHN0b3JlZCBpbiBjaGVtaWNhbCJ9LHsiaWQiOiJRNjY2MyIsIm5hbWUiOiJoYW1idXJnZXIiLCJkZXNjcmlwdGlvbiI6InNhbmR3aWNoIGNvbnNpc3Rpbmcgb2Ygb25lIG9yIG1vcmUgY29va2VkIHBhdHRpZXMgb2YgZ3JvdW5kIG1lYXQsIHVzdWFsbHkgYmVlZiwgcGxhY2VkIGluc2lkZSBhIHNsaWNlZCBicmVhZCByb2xsIG9yIGJ1biJ9LHsiaWQiOiJRMTk4NjA5OCIsIm5hbWUiOiJzdGFuZGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcG9zaXRpb24gaW4gd2hpY2ggdGhlIGJvZHkgaXMgaGVsZCBpbiBhbiB1cHJpZ2h0IHBvc2l0aW9uIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE5ODYwOTgiLCJuYW1lIjoic3RhbmRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHBvc2l0aW9uIGluIHdoaWNoIHRoZSBib2R5IGlzIGhlbGQgaW4gYW4gdXByaWdodCBwb3NpdGlvbiJ9LHsiaWQiOiJRMTE0NDU5MyIsIm5hbWUiOiJzaXR0aW5nIiwiZGVzY3JpcHRpb24iOiJodW1hbiByZXN0aW5nIHBvc2l0aW9uOyBib2R5IHdlaWdodCBpcyBzdXBwb3J0ZWQgcHJpbWFyaWx5IGJ5IHRoZSBidXR0b2NrcyBpbiBjb250YWN0IHdpdGggdGhlIGdyb3VuZCBvciBhIGhvcml6b250YWwgb2JqZWN0IHN1Y2ggYXMgYSBjaGFpciJ9LHsiaWQiOiJRMzI0NjM1MyIsIm5hbWUiOiJkaWV0IHNvZGEiLCJkZXNjcmlwdGlvbiI6InR5cGUgb2Ygc3VnYXItZnJlZSBvciBhcnRpZmljaWFsbHkgc3dlZXRlbmVkIHNvZGEifSx7ImlkIjoiUTU2Njg4OSIsIm5hbWUiOiJvcmRlciIsImRlc2NyaXB0aW9uIjoic3RhdGVkIGludGVudGlvbiB0byBlbmdhZ2UgaW4gYSBjb21tZXJjaWFsIHRyYW5zYWN0aW9uIGZvciBzcGVjaWZpYyBwcm9kdWN0cyBvciBzZXJ2aWNlcyJ9XQ=="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask21(
    override val poolId: String = "21",
    override val result: Result = Result("v_05720", 318f, 336f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTMxMzMiLCJuYW1lIjoiZ3JlZW4iLCJkZXNjcmlwdGlvbiI6ImNvbG9yOyBhZGRpdGl2ZSBwcmltYXJ5IGNvbG9yOyB2aXNpYmxlIGJldHdlZW4gYmx1ZSBhbmQgeWVsbG93In0seyJpZCI6IlE3Njc2OCIsIm5hbWUiOiJzaGlydCIsImRlc2NyaXB0aW9uIjoiZ2FybWVudCBmb3IgdGhlIHVwcGVyIGJvZHkifSx7ImlkIjoiUTE3MzEwNTM3IiwibmFtZSI6InNjdWxwdHVyZSIsImRlc2NyaXB0aW9uIjoibWFudWZhY3R1cmUgb2Ygc2N1bHB0dXJlcyBpbiBhcnRzIGFuZCBjcmFmdHMifSx7ImlkIjoiUTIyMTYyMzYiLCJuYW1lIjoicm9vc3RlciIsImRlc2NyaXB0aW9uIjoibWFsZSBjaGlja2VuIn0seyJpZCI6IlEyMDAyNjYiLCJuYW1lIjoiaGFuZGxlIiwiZGVzY3JpcHRpb24iOiJwYXJ0IG9mIGRldmljZSBkZXNpZ25lZCB0byBiZSBoZWxkIn1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTI4NTAzNzUxIiwibmFtZSI6InNwZWFrZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiBjYXBhYmxlIG9mIHZlcmJhbCBjb21tdW5pY2F0aW9uIn0seyJpZCI6IlE5MTM0IiwibmFtZSI6Im15dGhvbG9neSIsImRlc2NyaXB0aW9uIjoic3RvcmllcyBvZiBnb2RzIGFuZCBmYWlyaWVzIGFuZCBmYW50YXN0aWMgY3JlYXR1cmVzIn0seyJpZCI6IlE3MjkiLCJuYW1lIjoiYW5pbWFsIiwiZGVzY3JpcHRpb24iOiJraW5nZG9tIG9mIG11bHRpY2VsbHVsYXIgZXVrYXJ5b3RpYyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDQ1OTMiLCJuYW1lIjoic2l0dGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcmVzdGluZyBwb3NpdGlvbjsgYm9keSB3ZWlnaHQgaXMgc3VwcG9ydGVkIHByaW1hcmlseSBieSB0aGUgYnV0dG9ja3MgaW4gY29udGFjdCB3aXRoIHRoZSBncm91bmQgb3IgYSBob3Jpem9udGFsIG9iamVjdCBzdWNoIGFzIGEgY2hhaXIifSx7ImlkIjoiUTE1MDI2IiwibmFtZSI6ImNoYWlyIiwiZGVzY3JpcHRpb24iOiJwaWVjZSBvZiBmdXJuaXR1cmUgZm9yIHNpdHRpbmcgb24ifSx7ImlkIjoiUTE3MzEwNTM3IiwibmFtZSI6InNjdWxwdHVyZSIsImRlc2NyaXB0aW9uIjoibWFudWZhY3R1cmUgb2Ygc2N1bHB0dXJlcyBpbiBhcnRzIGFuZCBjcmFmdHMifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDQ1OTMiLCJuYW1lIjoic2l0dGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcmVzdGluZyBwb3NpdGlvbjsgYm9keSB3ZWlnaHQgaXMgc3VwcG9ydGVkIHByaW1hcmlseSBieSB0aGUgYnV0dG9ja3MgaW4gY29udGFjdCB3aXRoIHRoZSBncm91bmQgb3IgYSBob3Jpem9udGFsIG9iamVjdCBzdWNoIGFzIGEgY2hhaXIifSx7ImlkIjoiUTE4MzQyNzM4IiwibmFtZSI6InB1YmxpYyBzcGVha2luZyIsImRlc2NyaXB0aW9uIjoicHJvY2VzcyBhbmQgYWN0IG9mIHNwZWFraW5nIG9yIGdpdmluZyBhIGxlY3R1cmUgdG8gYSBncm91cCBvZiBwZW9wbGUgaW4gYSBzdHJ1Y3R1cmVkLCBkZWxpYmVyYXRlIG1hbm5lciBpbnRlbmRlZCB0byBpbmZvcm0sIGluZmx1ZW5jZSwgb3IgZW50ZXJ0YWluIGEgbGlzdGVuaW5nIGF1ZGllbmNlIn0seyJpZCI6IlE5MTM0IiwibmFtZSI6Im15dGhvbG9neSIsImRlc2NyaXB0aW9uIjoic3RvcmllcyBvZiBnb2RzIGFuZCBmYWlyaWVzIGFuZCBmYW50YXN0aWMgY3JlYXR1cmVzIn0seyJpZCI6IlExNzQyMTkiLCJuYW1lIjoicGFpbnQiLCJkZXNjcmlwdGlvbiI6ImNvbG9yZWQgY29tcG9zaXRpb24gYXBwbGllZCBvdmVyIGEgc3VyZmFjZSB0aGF0IGRyaWVzIGFzIGEgc29saWQgZmlsbSJ9LHsiaWQiOiJRMjYzNzgxNCIsIm5hbWUiOiJyYWNrIG9mIHNoZWx2ZXMiLCJkZXNjcmlwdGlvbiI6InNldCBvZiBzaGVsdmVzLCBjb21iaW5lZCBpbnRvIG9uZSBwaWVjZSBvZiBmdXJuaXR1cmUifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask22(
    override val poolId: String = "22",
    override val result: Result = Result("v_05503", 48f, 68f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTIzNDQ0IiwibmFtZSI6IndoaXRlIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlE0MDA4MCIsIm5hbWUiOiJiZWFjaCIsImRlc2NyaXB0aW9uIjoiYXJlYSBvZiBzYW5kIG9yIHNtYWxsIHN0b25lcyBuZWFyIHRoZSBzZWEgb3IgYW5vdGhlciBhcmVhIG9mIHdhdGVyIHN1Y2ggYXMgYSBsYWtlIn0seyJpZCI6IlExMTQ0NTkzIiwibmFtZSI6InNpdHRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHJlc3RpbmcgcG9zaXRpb247IGJvZHkgd2VpZ2h0IGlzIHN1cHBvcnRlZCBwcmltYXJpbHkgYnkgdGhlIGJ1dHRvY2tzIGluIGNvbnRhY3Qgd2l0aCB0aGUgZ3JvdW5kIG9yIGEgaG9yaXpvbnRhbCBvYmplY3Qgc3VjaCBhcyBhIGNoYWlyIn0seyJpZCI6IlEzMTMzIiwibmFtZSI6ImdyZWVuIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgcHJpbWFyeSBjb2xvcjsgdmlzaWJsZSBiZXR3ZWVuIGJsdWUgYW5kIHllbGxvdyJ9LHsiaWQiOiJRMzE0MiIsIm5hbWUiOiJyZWQiLCJkZXNjcmlwdGlvbiI6ImNvbG9yIn0seyJpZCI6IlExNzE1MjkiLCJuYW1lIjoiY2Fub2UiLCJkZXNjcmlwdGlvbiI6ImxpZ2h0IGJvYXQgdGhhdCBpcyBwYWRkbGVkIn1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTI4NTAzNzUxIiwibmFtZSI6InNwZWFrZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiBjYXBhYmxlIG9mIHZlcmJhbCBjb21tdW5pY2F0aW9uIn0seyJpZCI6IlEyMzQ0NjAiLCJuYW1lIjoidGV4dCIsImRlc2NyaXB0aW9uIjoib2JqZWN0IHRoYXQgY2FuIGJlIFxcXCJyZWFkXFxcIiBieSByZWFkZXI7IHJlc3VsdCBvZiB3cml0aW5nIn0seyJpZCI6IlE0MDA4MCIsIm5hbWUiOiJiZWFjaCIsImRlc2NyaXB0aW9uIjoiYXJlYSBvZiBzYW5kIG9yIHNtYWxsIHN0b25lcyBuZWFyIHRoZSBzZWEgb3IgYW5vdGhlciBhcmVhIG9mIHdhdGVyIHN1Y2ggYXMgYSBsYWtlIn0seyJpZCI6IlExNzE1MjkiLCJuYW1lIjoiY2Fub2UiLCJkZXNjcmlwdGlvbiI6ImxpZ2h0IGJvYXQgdGhhdCBpcyBwYWRkbGVkIn0seyJpZCI6IlExMDg4NCIsIm5hbWUiOiJ0cmVlIiwiZGVzY3JpcHRpb24iOiJwZXJlbm5pYWwgd29vZHkgcGxhbnQifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJROTk4IiwibmFtZSI6ImJhYnkiLCJkZXNjcmlwdGlvbiI6InZlcnkgeW91bmcgb2Zmc3ByaW5nIG9mIGEgaHVtYW4ifSx7ImlkIjoiUTE2NSIsIm5hbWUiOiJzZWEiLCJkZXNjcmlwdGlvbiI6ImxhcmdlIGJvZHkgb2Ygc2FsaW5lIHdhdGVyIn0seyJpZCI6IlEyMjMwNDQiLCJuYW1lIjoidHVydGxlIiwiZGVzY3JpcHRpb24iOiJvcmRlciBvZiByZXB0aWxlcyJ9LHsiaWQiOiJRMTIwMDQzIiwibmFtZSI6IkxlYXRoZXJiYWNrIHNlYSB0dXJ0bGUiLCJkZXNjcmlwdGlvbiI6InNwZWNpZXMgb2YgcmVwdGlsZSJ9LHsiaWQiOiJRMjAzNTM4IiwibmFtZSI6Imhhd2tzYmlsbCBzZWEgdHVydGxlIiwiZGVzY3JpcHRpb24iOiJzcGVjaWVzIG9mIHJlcHRpbGUifSx7ImlkIjoiUTE5MjA5NSIsIm5hbWUiOiJsb2dnZXJoZWFkIHNlYSB0dXJ0bGUiLCJkZXNjcmlwdGlvbiI6InNwZWNpZXMgb2YgdHVydGxlIn0seyJpZCI6IlEzNDY3OSIsIm5hbWUiOiJzYW5kIiwiZGVzY3JpcHRpb24iOiJncmFudWxhciBtYXRlcmlhbCBjb21wb3NlZCBvZiBmaW5lbHkgZGl2aWRlZCByb2NrIGFuZCBtaW5lcmFsIHBhcnRpY2xlcywgc2FuZCBwYXJ0aWNsZXMgcmFuZ2UgaW4gZGlhbWV0ZXIgZnJvbSAwLjA2MyB0byAyIG1tIChwZXIgSVNPIDE0Njg4KSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTY1IiwibmFtZSI6InNlYSIsImRlc2NyaXB0aW9uIjoibGFyZ2UgYm9keSBvZiBzYWxpbmUgd2F0ZXIifSx7ImlkIjoiUTM0Njc5IiwibmFtZSI6InNhbmQiLCJkZXNjcmlwdGlvbiI6ImdyYW51bGFyIG1hdGVyaWFsIGNvbXBvc2VkIG9mIGZpbmVseSBkaXZpZGVkIHJvY2sgYW5kIG1pbmVyYWwgcGFydGljbGVzLCBzYW5kIHBhcnRpY2xlcyByYW5nZSBpbiBkaWFtZXRlciBmcm9tIDAuMDYzIHRvIDIgbW0gKHBlciBJU08gMTQ2ODgpIn1d"
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask23(
    override val poolId: String = "23",
    override val result: Result = Result("v_01811", 62f, 86f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTEwODgiLCJuYW1lIjoiYmx1ZSIsImRlc2NyaXB0aW9uIjoiY29sb3I7IGFkZGl0aXZlIGFuZCBzdWJ0cmFjdGl2ZSAoUllCKSBwcmltYXJ5IGNvbG9yOyB2aXNpYmxlIGJldHdlZW4gcHVycGxlIGFuZCBncmVlbiJ9LHsiaWQiOiJRODAxNTEiLCJuYW1lIjoiaGF0IiwiZGVzY3JpcHRpb24iOiJzaGFwZWQgaGVhZCBjb3ZlcmluZywgaGF2aW5nIGEgYnJpbSBhbmQgYSBjcm93biwgb3Igb25lIG9mIHRoZXNlIn0seyJpZCI6IlE4MzM2MyIsIm5hbWUiOiJqZWFucyIsImRlc2NyaXB0aW9uIjoidHJvdXNlcnMgb2Z0ZW4gbWFkZSBmcm9tIGRlbmltIG9yIGR1bmdhcmVlIGNsb3RoIn0seyJpZCI6IlExNTc4MyIsIm5hbWUiOiJza2F0ZWJvYXJkIiwiZGVzY3JpcHRpb24iOiJ3aGVlbGVkIHdvb2RlbiBib2FyZCB1c2VkIGZvciBza2F0ZWJvYXJkaW5nIn1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTU3ODMiLCJuYW1lIjoic2thdGVib2FyZCIsImRlc2NyaXB0aW9uIjoid2hlZWxlZCB3b29kZW4gYm9hcmQgdXNlZCBmb3Igc2thdGVib2FyZGluZyJ9LHsiaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTIwNTEyMTIiLCJuYW1lIjoiaGFuZHJhaWwiLCJkZXNjcmlwdGlvbiI6IkEgdHlwZSBvZiByYWlsaW5nIHRoYXQgaXMgZGVzaWduZWQgdG8gYmUgZ3Jhc3BlZCBieSB0aGUgaGFuZCwgY29tbW9ubHkgZm91bmQgaW4gc3RhaXJ3YXlzIGFuZCBlc2NhbGF0b3JzIn0seyJpZCI6IlExMjUxMSIsIm5hbWUiOiJzdGFpcnMiLCJkZXNjcmlwdGlvbiI6ImNvbnN0cnVjdGlvbiBkZXNpZ25lZCB0byBicmlkZ2UgYSBsYXJnZSB2ZXJ0aWNhbCBkaXN0YW5jZSBieSBkaXZpZGluZyBpdCBpbnRvIHNtYWxsZXIgdmVydGljYWwgZGlzdGFuY2VzIn0seyJpZCI6IlE4NDIyODQiLCJuYW1lIjoic2thdGVib2FyZGluZyIsImRlc2NyaXB0aW9uIjoiYWN0aW9uIHNwb3J0IG9uIHNrYXRlYm9hcmRzIn0seyJpZCI6IlEyNzc2NjQ5IiwibmFtZSI6InNrYXRlYm9hcmRpbmcgdHJpY2siLCJkZXNjcmlwdGlvbiI6InRyaWNrIHBlcmZvcm1lZCBvbiBhIHNrYXRlYm9hcmQifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTY1NjY4MiIsIm5hbWUiOiJldmVudCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IGFuZCBzY2hlZHVsZWQgZXZlbnQsIGxpa2UgYSBmZXN0aXZhbCBvciBjb21wZXRpdGlvbiJ9LHsiaWQiOiJRMjM4ODMxNiIsIm5hbWUiOiJwdWJsaWMiLCJkZXNjcmlwdGlvbiI6Imdyb3VwaW5nIG9mIGluZGl2aWR1YWwgcGVvcGxlIn0seyJpZCI6IlE2MzgiLCJuYW1lIjoibXVzaWMiLCJkZXNjcmlwdGlvbiI6ImZvcm0gb2YgYXJ0IHVzaW5nIHNvdW5kIHNwZWNpZmljYWxseSJ9LHsiaWQiOiJRODQyMjg0IiwibmFtZSI6InNrYXRlYm9hcmRpbmciLCJkZXNjcmlwdGlvbiI6ImFjdGlvbiBzcG9ydCBvbiBza2F0ZWJvYXJkcyJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTIwNTEyMTIiLCJuYW1lIjoiaGFuZHJhaWwiLCJkZXNjcmlwdGlvbiI6IkEgdHlwZSBvZiByYWlsaW5nIHRoYXQgaXMgZGVzaWduZWQgdG8gYmUgZ3Jhc3BlZCBieSB0aGUgaGFuZCwgY29tbW9ubHkgZm91bmQgaW4gc3RhaXJ3YXlzIGFuZCBlc2NhbGF0b3JzIn0seyJpZCI6IlExMjUxMSIsIm5hbWUiOiJzdGFpcnMiLCJkZXNjcmlwdGlvbiI6ImNvbnN0cnVjdGlvbiBkZXNpZ25lZCB0byBicmlkZ2UgYSBsYXJnZSB2ZXJ0aWNhbCBkaXN0YW5jZSBieSBkaXZpZGluZyBpdCBpbnRvIHNtYWxsZXIgdmVydGljYWwgZGlzdGFuY2VzIn0seyJpZCI6IlExNTc4MyIsIm5hbWUiOiJza2F0ZWJvYXJkIiwiZGVzY3JpcHRpb24iOiJ3aGVlbGVkIHdvb2RlbiBib2FyZCB1c2VkIGZvciBza2F0ZWJvYXJkaW5nIn0seyJpZCI6IlE4NDIyODQiLCJuYW1lIjoic2thdGVib2FyZGluZyIsImRlc2NyaXB0aW9uIjoiYWN0aW9uIHNwb3J0IG9uIHNrYXRlYm9hcmRzIn0seyJpZCI6IlEyNzc2NjQ5IiwibmFtZSI6InNrYXRlYm9hcmRpbmcgdHJpY2siLCJkZXNjcmlwdGlvbiI6InRyaWNrIHBlcmZvcm1lZCBvbiBhIHNrYXRlYm9hcmQifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask24(
    override val poolId: String = "24",
    override val result: Result = Result("v_01991", 124f, 143f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTEwODgiLCJuYW1lIjoiYmx1ZSIsImRlc2NyaXB0aW9uIjoiY29sb3I7IGFkZGl0aXZlIGFuZCBzdWJ0cmFjdGl2ZSAoUllCKSBwcmltYXJ5IGNvbG9yOyB2aXNpYmxlIGJldHdlZW4gcHVycGxlIGFuZCBncmVlbiJ9LHsiaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlEyMzQ0NjAiLCJuYW1lIjoidGV4dCIsImRlc2NyaXB0aW9uIjoib2JqZWN0IHRoYXQgY2FuIGJlIFxcXCJyZWFkXFxcIiBieSByZWFkZXI7IHJlc3VsdCBvZiB3cml0aW5nIn0seyJpZCI6IlE2NTY3MjAiLCJuYW1lIjoid29ya3Nob3AiLCJkZXNjcmlwdGlvbiI6InJvb20gb3IgYnVpbGRpbmcsIHdpdGggdG9vbHMsIHVzZWQgdG8gcmVwYWlyIG9yIG1ha2UgZ29vZHMifSx7ImlkIjoiUTE1OTg5MjUzIiwibmFtZSI6InBhcnQgb2YiLCJkZXNjcmlwdGlvbiI6InNlcGFyYXRlIGVsZW1lbnQgb2YgYSBsYXJnZXIgKGRpdmlzaWJsZSBvciBpbmRpdmlzaWJsZSkgZW50aXR5In1d"
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTEyNTM1NiIsIm5hbWUiOiJzYXciLCJkZXNjcmlwdGlvbiI6InRvb2wgdXNlZCB0byBjdXQgdGhyb3VnaCB3b29kIG9yIG90aGVyIG1hdGVyaWFscyJ9LHsiaWQiOiJRMTE0MjYiLCJuYW1lIjoibWV0YWwiLCJkZXNjcmlwdGlvbiI6ImVsZW1lbnQsIGNvbXBvdW5kIG9yIGFsbG95IHRoYXQgaXMgYSBnb29kIGNvbmR1Y3RvciBvZiBib3RoIGVsZWN0cmljaXR5IGFuZCBoZWF0In1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDI2IiwibmFtZSI6Im1ldGFsIiwiZGVzY3JpcHRpb24iOiJlbGVtZW50LCBjb21wb3VuZCBvciBhbGxveSB0aGF0IGlzIGEgZ29vZCBjb25kdWN0b3Igb2YgYm90aCBlbGVjdHJpY2l0eSBhbmQgaGVhdCJ9LHsiaWQiOiJRNjk1ODc0NyIsIm5hbWUiOiJ3b3JrIiwiZGVzY3JpcHRpb24iOiJwYXJ0aWN1bGFyIGZvcm0gb2YgYWN0aXZpdHksIHNvbGQgYnkgbWFueSBwZW9wbGUgdG8gc3VzdGFpbiB0aGVtc2VsdmVzIn0seyJpZCI6IlExNjIxNTk3IiwibmFtZSI6IldvcmtiZW5jaCIsImRlc2NyaXB0aW9uIjoiIn0seyJpZCI6IlE2NTY3MjAiLCJuYW1lIjoid29ya3Nob3AiLCJkZXNjcmlwdGlvbiI6InJvb20gb3IgYnVpbGRpbmcsIHdpdGggdG9vbHMsIHVzZWQgdG8gcmVwYWlyIG9yIG1ha2UgZ29vZHMifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE4MzQyNzM4IiwibmFtZSI6InB1YmxpYyBzcGVha2luZyIsImRlc2NyaXB0aW9uIjoicHJvY2VzcyBhbmQgYWN0IG9mIHNwZWFraW5nIG9yIGdpdmluZyBhIGxlY3R1cmUgdG8gYSBncm91cCBvZiBwZW9wbGUgaW4gYSBzdHJ1Y3R1cmVkLCBkZWxpYmVyYXRlIG1hbm5lciBpbnRlbmRlZCB0byBpbmZvcm0sIGluZmx1ZW5jZSwgb3IgZW50ZXJ0YWluIGEgbGlzdGVuaW5nIGF1ZGllbmNlIn0seyJpZCI6IlExNzg2NTEiLCJuYW1lIjoiaW50ZXJ2aWV3IiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmVkIHNlcmllcyBvZiBxdWVzdGlvbnMgYW5kIGFuc3dlcnMifV0="
                    )
                )
            )
        )
    )
) : Pool()

data class PoolTask25(
    override val poolId: String = "25",
    override val result: Result = Result("v_06426", 91f, 111f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjgzIiwibmFtZSI6IndhdGVyIiwiZGVzY3JpcHRpb24iOiJjaGVtaWNhbCBjb21wb3VuZDsgbWFpbiBjb25zdGl0dWVudCBvZiB0aGUgZmx1aWRzIG9mIG1vc3QgbGl2aW5nIG9yZ2FuaXNtcyJ9LHsiaWQiOiJRNDMyNjEiLCJuYW1lIjoiaG9yaXpvbiIsImRlc2NyaXB0aW9uIjoiYXBwYXJlbnQgbGluZSB0aGF0IHNlcGFyYXRlcyBlYXJ0aCBmcm9tIHNreSJ9LHsiaWQiOiJRMTUzMjgiLCJuYW1lIjoiY2FtZXJhIiwiZGVzY3JpcHRpb24iOiJvcHRpY2FsIGRldmljZSBmb3IgcmVjb3JkaW5nIG9yIHRyYW5zbWl0dGluZyBwaG90b2dyYXBoaWMgaW1hZ2VzIG9yIHZpZGVvcyJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzU4NzIiLCJuYW1lIjoiYm9hdCIsImRlc2NyaXB0aW9uIjoic21hbGxlciB3YXRlcmNyYWZ0In0seyJpZCI6IlEyNDcyNTg3IiwibmFtZSI6InBlb3BsZSIsImRlc2NyaXB0aW9uIjoicGx1cmFsaXR5IG9mIHBlcnNvbnMgY29uc2lkZXJlZCBhcyBhIHdob2xlLCBmcm9tIGEgZ292ZXJubWVudCBwZXJzcGVjdGl2ZSJ9LHsiaWQiOiJRMTA4OCIsIm5hbWUiOiJibHVlIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgYW5kIHN1YnRyYWN0aXZlIChSWUIpIHByaW1hcnkgY29sb3I7IHZpc2libGUgYmV0d2VlbiBwdXJwbGUgYW5kIGdyZWVuIn0seyJpZCI6IlE3Njc2OCIsIm5hbWUiOiJzaGlydCIsImRlc2NyaXB0aW9uIjoiZ2FybWVudCBmb3IgdGhlIHVwcGVyIGJvZHkifSx7ImlkIjoiUTMxNDIiLCJuYW1lIjoicmVkIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRMjQ1Mjk3ODAiLCJuYW1lIjoicG9pbnQiLCJkZXNjcmlwdGlvbiI6InRhcGVyaW5nIGxhbmRmb3JtLCBwcm9qZWN0aW5nIGludG8gYSBib2R5IG9mIHdhdGVyIn0seyJpZCI6IlEyODMiLCJuYW1lIjoid2F0ZXIiLCJkZXNjcmlwdGlvbiI6ImNoZW1pY2FsIGNvbXBvdW5kOyBtYWluIGNvbnN0aXR1ZW50IG9mIHRoZSBmbHVpZHMgb2YgbW9zdCBsaXZpbmcgb3JnYW5pc21zIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjQ3MjU4NyIsIm5hbWUiOiJwZW9wbGUiLCJkZXNjcmlwdGlvbiI6InBsdXJhbGl0eSBvZiBwZXJzb25zIGNvbnNpZGVyZWQgYXMgYSB3aG9sZSwgZnJvbSBhIGdvdmVybm1lbnQgcGVyc3BlY3RpdmUifSx7ImlkIjoiUTIzNDQyIiwibmFtZSI6ImlzbGFuZCIsImRlc2NyaXB0aW9uIjoic3ViLWNvbnRpbmVudGFsIGxhbmQgdGhhdCBpcyBzdXJyb3VuZGVkIGJ5IHdhdGVyIn0seyJpZCI6IlEzNTg3MiIsIm5hbWUiOiJib2F0IiwiZGVzY3JpcHRpb24iOiJzbWFsbGVyIHdhdGVyY3JhZnQifSx7ImlkIjoiUTI4MyIsIm5hbWUiOiJ3YXRlciIsImRlc2NyaXB0aW9uIjoiY2hlbWljYWwgY29tcG91bmQ7IG1haW4gY29uc3RpdHVlbnQgb2YgdGhlIGZsdWlkcyBvZiBtb3N0IGxpdmluZyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTA3MjkzMjYiLCJuYW1lIjoicGlyYXRlIiwiZGVzY3JpcHRpb24iOiJwZXJzb24gcHJhY3RpY2luZyBwaXJhY3kifSx7ImlkIjoiUTM0NTg0NCIsIm5hbWUiOiJjcmV3IiwiZGVzY3JpcHRpb24iOiJncm91cCBvZiBwZW9wbGUgd2hvIHdvcmsgYXQgYSBjb21tb24gYWN0aXZpdHksIGdlbmVyYWxseSBpbiBhIHN0cnVjdHVyZWQgb3JnYW5pemF0aW9uIn0seyJpZCI6IlEzNTg3MiIsIm5hbWUiOiJib2F0IiwiZGVzY3JpcHRpb24iOiJzbWFsbGVyIHdhdGVyY3JhZnQifSx7ImlkIjoiUTEzNDUwMjgzIiwibmFtZSI6IndldHN1aXQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHdhdGVyIGFjdGl2aXRpZXMsIHByb3ZpZGluZyB0aGVybWFsIGluc3VsYXRpb24gYnV0IG5vdCBkZXNpZ25lZCB0byBwcmV2ZW50IHdhdGVyIGVudGVyaW5nIn0seyJpZCI6IlExNDY2MCIsIm5hbWUiOiJmbGFnIiwiZGVzY3JpcHRpb24iOiJwaWVjZSBvZiBmYWJyaWMgd2l0aCBhIGRpc3RpbmN0aXZlIGRlc2lnbiwgdXNlZCBhcyBhIHN5bWJvbCJ9LHsiaWQiOiJRMjM0NDIiLCJuYW1lIjoiaXNsYW5kIiwiZGVzY3JpcHRpb24iOiJzdWItY29udGluZW50YWwgbGFuZCB0aGF0IGlzIHN1cnJvdW5kZWQgYnkgd2F0ZXIifV0="
                    )
                )
            )
        )
    )
) : Pool()

abstract class LargePool {
    abstract val poolId: String
    abstract val result: Result
    abstract val query1: Query
    abstract val query2: Query
    abstract val query3: Query
    abstract val query4: Query
    abstract val query5: Query
    abstract val query6: Query
    abstract val query7: Query
    abstract val query8: Query
    abstract val query9: Query
}

data class LargePoolTask1(
    override val poolId: String = "01",
    override val result: Result = Result("v_06426", 91f, 111f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTUwMjYiLCJuYW1lIjoiY2hhaXIiLCJkZXNjcmlwdGlvbiI6InBpZWNlIG9mIGZ1cm5pdHVyZSBmb3Igc2l0dGluZyBvbiJ9LHsiaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDQ1OTMiLCJuYW1lIjoic2l0dGluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcmVzdGluZyBwb3NpdGlvbjsgYm9keSB3ZWlnaHQgaXMgc3VwcG9ydGVkIHByaW1hcmlseSBieSB0aGUgYnV0dG9ja3MgaW4gY29udGFjdCB3aXRoIHRoZSBncm91bmQgb3IgYSBob3Jpem9udGFsIG9iamVjdCBzdWNoIGFzIGEgY2hhaXIifSx7ImlkIjoiUTE5ODYwOTgiLCJuYW1lIjoic3RhbmRpbmciLCJkZXNjcmlwdGlvbiI6Imh1bWFuIHBvc2l0aW9uIGluIHdoaWNoIHRoZSBib2R5IGlzIGhlbGQgaW4gYW4gdXByaWdodCBwb3NpdGlvbiJ9LHsiaWQiOiJRNjU1NDEwMSIsIm5hbWUiOiJtZWRpY2FsIGRldmljZSIsImRlc2NyaXB0aW9uIjoiYW55IGluc3RydW1lbnQsIGFwcGFyYXR1cywgaW1wbGFudCwgaW4gdml0cm8gcmVhZ2VudCwgb3Igc2ltaWxhciBvciByZWxhdGVkIGFydGljbGUgdXNlZCBmb3IgZGlhZ25vc3RpYyBhbmQvb3IgdGhlcmFwZXV0aWMgcHVycG9zZXMifSx7ImlkIjoiUTE2OTE3IiwibmFtZSI6Imhvc3BpdGFsIiwiZGVzY3JpcHRpb24iOiJoZWFsdGggY2FyZSBmYWNpbGl0eSAoZm9yIG9yZ2FuaXphdGlvbnMgdXNlICBtZWRpY2FsIG9yZ2FuaXphdGlvbiAoUTQyODc3NDUpLCBmb3IgaW5kaXZpZHVhbCBidWlsZGluZ3MgdXNlIFEzOTM2NDcyMykifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE0MTE3MjUiLCJuYW1lIjoiY3Jhd2xpbmciLCJkZXNjcmlwdGlvbiI6Im1vdmluZyBhbG9uZyB0aGUgZ3JvdW5kIG9uIGhhbmRzIGFuZCBrbmVlcyJ9LHsiaWQiOiJRMjE3MTY0IiwibmFtZSI6ImZsb29yIiwiZGVzY3JpcHRpb24iOiJ3YWxraW5nIHN1cmZhY2Ugb2YgYSByb29tIn0seyJpZCI6IlEyMzQ0NSIsIm5hbWUiOiJibGFjayIsImRlc2NyaXB0aW9uIjoiZGFya2VzdCBjb2xvciwgcmVzdWx0aW5nIGZyb20gdGhlIGFic2VuY2Ugb3IgY29tcGxldGUgYWJzb3JwdGlvbiBvZiBsaWdodC4gTGlrZSB3aGl0ZSBhbmQgZ3JleSwgaXQgaXMgYW4gYWNocm9tYXRpYyBjb2xvciwgbGl0ZXJhbGx5IGEgY29sb3Igd2l0aG91dCBodWUifSx7ImlkIjoiUTU4NDAxMyIsIm5hbWUiOiJGYWRlYXdheSIsImRlc2NyaXB0aW9uIjoiIn0seyJpZCI6IlExNjkxNyIsIm5hbWUiOiJob3NwaXRhbCIsImRlc2NyaXB0aW9uIjoiaGVhbHRoIGNhcmUgZmFjaWxpdHkgKGZvciBvcmdhbml6YXRpb25zIHVzZSAgbWVkaWNhbCBvcmdhbml6YXRpb24gKFE0Mjg3NzQ1KSwgZm9yIGluZGl2aWR1YWwgYnVpbGRpbmdzIHVzZSBRMzkzNjQ3MjMpIn1d"
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTUxMjE3MDgiLCJuYW1lIjoiY2lyY3VsYXRvcnkgY29sbGFwc2UiLCJkZXNjcmlwdGlvbiI6ImZhaWx1cmUgb2YgY2lyY3VsYXRpb24sIHN1Y2ggYXMgYmxvb2QgZmxvdyJ9LHsiaWQiOiJRMjI2ODc3NiIsIm5hbWUiOiJseWluZyIsImRlc2NyaXB0aW9uIjoiaHVtYW4gcG9zaXRpb24gaW4gd2hpY2ggdGhlIGJvZHkgaXMgbW9yZSBvciBsZXNzIGhvcml6b250YWwgYW5kIHN1cHBvcnRlZCBhbG9uZyBpdHMgbGVuZ3RoIGJ5IHRoZSBzdXJmYWNlIHVuZGVybmVhdGgifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMTY5MTciLCJuYW1lIjoiaG9zcGl0YWwiLCJkZXNjcmlwdGlvbiI6ImhlYWx0aCBjYXJlIGZhY2lsaXR5IChmb3Igb3JnYW5pemF0aW9ucyB1c2UgIG1lZGljYWwgb3JnYW5pemF0aW9uIChRNDI4Nzc0NSksIGZvciBpbmRpdmlkdWFsIGJ1aWxkaW5ncyB1c2UgUTM5MzY0NzIzKSJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMTE0NDU5MyIsIm5hbWUiOiJzaXR0aW5nIiwiZGVzY3JpcHRpb24iOiJodW1hbiByZXN0aW5nIHBvc2l0aW9uOyBib2R5IHdlaWdodCBpcyBzdXBwb3J0ZWQgcHJpbWFyaWx5IGJ5IHRoZSBidXR0b2NrcyBpbiBjb250YWN0IHdpdGggdGhlIGdyb3VuZCBvciBhIGhvcml6b250YWwgb2JqZWN0IHN1Y2ggYXMgYSBjaGFpciJ9LHsiaWQiOiJRMTY5MTciLCJuYW1lIjoiaG9zcGl0YWwiLCJkZXNjcmlwdGlvbiI6ImhlYWx0aCBjYXJlIGZhY2lsaXR5IChmb3Igb3JnYW5pemF0aW9ucyB1c2UgIG1lZGljYWwgb3JnYW5pemF0aW9uIChRNDI4Nzc0NSksIGZvciBpbmRpdmlkdWFsIGJ1aWxkaW5ncyB1c2UgUTM5MzY0NzIzKSJ9LHsiaWQiOiJRMzE0MDk3MSIsIm5hbWUiOiJob3NwaXRhbGl6YXRpb24iLCJkZXNjcmlwdGlvbiI6ImFkbWlzc2lvbiBvZiBhIHBhdGllbnQgdG8gYSBob3NwaXRhbCJ9LHsiaWQiOiJRNjU1NDEwMSIsIm5hbWUiOiJtZWRpY2FsIGRldmljZSIsImRlc2NyaXB0aW9uIjoiYW55IGluc3RydW1lbnQsIGFwcGFyYXR1cywgaW1wbGFudCwgaW4gdml0cm8gcmVhZ2VudCwgb3Igc2ltaWxhciBvciByZWxhdGVkIGFydGljbGUgdXNlZCBmb3IgZGlhZ25vc3RpYyBhbmQvb3IgdGhlcmFwZXV0aWMgcHVycG9zZXMifSx7ImlkIjoiUTI2Mzc4MTQiLCJuYW1lIjoicmFjayBvZiBzaGVsdmVzIiwiZGVzY3JpcHRpb24iOiJzZXQgb2Ygc2hlbHZlcywgY29tYmluZWQgaW50byBvbmUgcGllY2Ugb2YgZnVybml0dXJlIn1d"
                    )
                )
            )
        )
    ),
    override val query5: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjgzIiwibmFtZSI6IndhdGVyIiwiZGVzY3JpcHRpb24iOiJjaGVtaWNhbCBjb21wb3VuZDsgbWFpbiBjb25zdGl0dWVudCBvZiB0aGUgZmx1aWRzIG9mIG1vc3QgbGl2aW5nIG9yZ2FuaXNtcyJ9LHsiaWQiOiJRNTExMyIsIm5hbWUiOiJiaXJkIiwiZGVzY3JpcHRpb24iOiJjbGFzcyBvZiB0ZXRyYXBvZHMifSx7ImlkIjoiUTIxNTYyNyIsIm5hbWUiOiJwZXJzb24iLCJkZXNjcmlwdGlvbiI6ImJlaW5nIHRoYXQgaGFzIGNlcnRhaW4gY2FwYWNpdGllcyBvciBhdHRyaWJ1dGVzIGNvbnN0aXR1dGluZyBwZXJzb25ob29kIChhdm9pZCB1c2Ugd2l0aCBQMzE7IHVzZSBRNSBmb3IgaHVtYW5zKSJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query6: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTcxIiwibmFtZSI6ImJvb2siLCJkZXNjcmlwdGlvbiI6Im1lZGl1bSBmb3IgcmVjb3JkaW5nIGluZm9ybWF0aW9uIGluIHRoZSBmb3JtIG9mIHdyaXRpbmcgb3IgaW1hZ2VzIn1d"
                    )
                )
            )
        )
    ),
    override val query7: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNTExMyIsIm5hbWUiOiJiaXJkIiwiZGVzY3JpcHRpb24iOiJjbGFzcyBvZiB0ZXRyYXBvZHMifSx7ImlkIjoiUTI4MyIsIm5hbWUiOiJ3YXRlciIsImRlc2NyaXB0aW9uIjoiY2hlbWljYWwgY29tcG91bmQ7IG1haW4gY29uc3RpdHVlbnQgb2YgdGhlIGZsdWlkcyBvZiBtb3N0IGxpdmluZyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query8: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDU3Njg5IiwibmFtZSI6InN1cmZib2FyZCIsImRlc2NyaXB0aW9uIjoiZWxvbmdhdGVkIHBsYXRmb3JtIHVzZWQgaW4gdGhlIHNwb3J0IG9mIHN1cmZpbmcifSx7ImlkIjoiUTQwMDgwIiwibmFtZSI6ImJlYWNoIiwiZGVzY3JpcHRpb24iOiJhcmVhIG9mIHNhbmQgb3Igc21hbGwgc3RvbmVzIG5lYXIgdGhlIHNlYSBvciBhbm90aGVyIGFyZWEgb2Ygd2F0ZXIgc3VjaCBhcyBhIGxha2UifSx7ImlkIjoiUTEwMzU0NzgzIiwibmFtZSI6InByYWN0aWNlIiwiZGVzY3JpcHRpb24iOiJtYW5pZmVzdGluZyB0aGVvcnkgaW50byBwaHlzaWNhbCBhY3Rpb24ifSx7ImlkIjoiUTM3MjI2IiwibmFtZSI6InRlYWNoZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiB3aG8gaGVscHMgb3RoZXJzIHRvIGFjcXVpcmUga25vd2xlZGdlLCBjb21wZXRlbmNlcyBvciB2YWx1ZXMifV0="
                    )
                )
            )
        )
    ),
    override val query9: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTA1Njc0IiwibmFtZSI6InJ1bm5pbmciLCJkZXNjcmlwdGlvbiI6Im1ldGhvZCBvZiB0ZXJyZXN0cmlhbCBsb2NvbW90aW9uIGFsbG93aW5nIGh1bWFucyBhbmQgb3RoZXIgYW5pbWFscyB0byBtb3ZlIHJhcGlkbHkgb24gZm9vdCJ9LHsiaWQiOiJRNDAwODAiLCJuYW1lIjoiYmVhY2giLCJkZXNjcmlwdGlvbiI6ImFyZWEgb2Ygc2FuZCBvciBzbWFsbCBzdG9uZXMgbmVhciB0aGUgc2VhIG9yIGFub3RoZXIgYXJlYSBvZiB3YXRlciBzdWNoIGFzIGEgbGFrZSJ9LHsiaWQiOiJRMTY4ODczODAiLCJuYW1lIjoiZ3JvdXAiLCJkZXNjcmlwdGlvbiI6InN1bW1hcml6ZXMgZW50aXRpZXMgd2l0aCBzaW1pbGFyIGNoYXJhY3RlcmlzdGljcyB0b2dldGhlciJ9XQ=="
                    )
                )
            )
        ),
    )
) : LargePool()

data class LargePoolTask2(
    override val poolId: String = "02",
    override val result: Result = Result("v_06426", 91f, 111f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjgzIiwibmFtZSI6IndhdGVyIiwiZGVzY3JpcHRpb24iOiJjaGVtaWNhbCBjb21wb3VuZDsgbWFpbiBjb25zdGl0dWVudCBvZiB0aGUgZmx1aWRzIG9mIG1vc3QgbGl2aW5nIG9yZ2FuaXNtcyJ9LHsiaWQiOiJRNDMyNjEiLCJuYW1lIjoiaG9yaXpvbiIsImRlc2NyaXB0aW9uIjoiYXBwYXJlbnQgbGluZSB0aGF0IHNlcGFyYXRlcyBlYXJ0aCBmcm9tIHNreSJ9LHsiaWQiOiJRMTUzMjgiLCJuYW1lIjoiY2FtZXJhIiwiZGVzY3JpcHRpb24iOiJvcHRpY2FsIGRldmljZSBmb3IgcmVjb3JkaW5nIG9yIHRyYW5zbWl0dGluZyBwaG90b2dyYXBoaWMgaW1hZ2VzIG9yIHZpZGVvcyJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTA3MjkzMjYiLCJuYW1lIjoicGlyYXRlIiwiZGVzY3JpcHRpb24iOiJwZXJzb24gcHJhY3RpY2luZyBwaXJhY3kifSx7ImlkIjoiUTM0NTg0NCIsIm5hbWUiOiJjcmV3IiwiZGVzY3JpcHRpb24iOiJncm91cCBvZiBwZW9wbGUgd2hvIHdvcmsgYXQgYSBjb21tb24gYWN0aXZpdHksIGdlbmVyYWxseSBpbiBhIHN0cnVjdHVyZWQgb3JnYW5pemF0aW9uIn0seyJpZCI6IlEzNTg3MiIsIm5hbWUiOiJib2F0IiwiZGVzY3JpcHRpb24iOiJzbWFsbGVyIHdhdGVyY3JhZnQifSx7ImlkIjoiUTEzNDUwMjgzIiwibmFtZSI6IndldHN1aXQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHdhdGVyIGFjdGl2aXRpZXMsIHByb3ZpZGluZyB0aGVybWFsIGluc3VsYXRpb24gYnV0IG5vdCBkZXNpZ25lZCB0byBwcmV2ZW50IHdhdGVyIGVudGVyaW5nIn0seyJpZCI6IlExNDY2MCIsIm5hbWUiOiJmbGFnIiwiZGVzY3JpcHRpb24iOiJwaWVjZSBvZiBmYWJyaWMgd2l0aCBhIGRpc3RpbmN0aXZlIGRlc2lnbiwgdXNlZCBhcyBhIHN5bWJvbCJ9LHsiaWQiOiJRMjM0NDIiLCJuYW1lIjoiaXNsYW5kIiwiZGVzY3JpcHRpb24iOiJzdWItY29udGluZW50YWwgbGFuZCB0aGF0IGlzIHN1cnJvdW5kZWQgYnkgd2F0ZXIifV0="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzU4NzIiLCJuYW1lIjoiYm9hdCIsImRlc2NyaXB0aW9uIjoic21hbGxlciB3YXRlcmNyYWZ0In0seyJpZCI6IlEyNDcyNTg3IiwibmFtZSI6InBlb3BsZSIsImRlc2NyaXB0aW9uIjoicGx1cmFsaXR5IG9mIHBlcnNvbnMgY29uc2lkZXJlZCBhcyBhIHdob2xlLCBmcm9tIGEgZ292ZXJubWVudCBwZXJzcGVjdGl2ZSJ9LHsiaWQiOiJRMTA4OCIsIm5hbWUiOiJibHVlIiwiZGVzY3JpcHRpb24iOiJjb2xvcjsgYWRkaXRpdmUgYW5kIHN1YnRyYWN0aXZlIChSWUIpIHByaW1hcnkgY29sb3I7IHZpc2libGUgYmV0d2VlbiBwdXJwbGUgYW5kIGdyZWVuIn0seyJpZCI6IlE3Njc2OCIsIm5hbWUiOiJzaGlydCIsImRlc2NyaXB0aW9uIjoiZ2FybWVudCBmb3IgdGhlIHVwcGVyIGJvZHkifSx7ImlkIjoiUTMxNDIiLCJuYW1lIjoicmVkIiwiZGVzY3JpcHRpb24iOiJjb2xvciJ9LHsiaWQiOiJRMjQ1Mjk3ODAiLCJuYW1lIjoicG9pbnQiLCJkZXNjcmlwdGlvbiI6InRhcGVyaW5nIGxhbmRmb3JtLCBwcm9qZWN0aW5nIGludG8gYSBib2R5IG9mIHdhdGVyIn0seyJpZCI6IlEyODMiLCJuYW1lIjoid2F0ZXIiLCJkZXNjcmlwdGlvbiI6ImNoZW1pY2FsIGNvbXBvdW5kOyBtYWluIGNvbnN0aXR1ZW50IG9mIHRoZSBmbHVpZHMgb2YgbW9zdCBsaXZpbmcgb3JnYW5pc21zIn1d"
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMjQ3MjU4NyIsIm5hbWUiOiJwZW9wbGUiLCJkZXNjcmlwdGlvbiI6InBsdXJhbGl0eSBvZiBwZXJzb25zIGNvbnNpZGVyZWQgYXMgYSB3aG9sZSwgZnJvbSBhIGdvdmVybm1lbnQgcGVyc3BlY3RpdmUifSx7ImlkIjoiUTIzNDQyIiwibmFtZSI6ImlzbGFuZCIsImRlc2NyaXB0aW9uIjoic3ViLWNvbnRpbmVudGFsIGxhbmQgdGhhdCBpcyBzdXJyb3VuZGVkIGJ5IHdhdGVyIn0seyJpZCI6IlEzNTg3MiIsIm5hbWUiOiJib2F0IiwiZGVzY3JpcHRpb24iOiJzbWFsbGVyIHdhdGVyY3JhZnQifSx7ImlkIjoiUTI4MyIsIm5hbWUiOiJ3YXRlciIsImRlc2NyaXB0aW9uIjoiY2hlbWljYWwgY29tcG91bmQ7IG1haW4gY29uc3RpdHVlbnQgb2YgdGhlIGZsdWlkcyBvZiBtb3N0IGxpdmluZyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    ),
    override val query5: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTEwODgiLCJuYW1lIjoiYmx1ZSIsImRlc2NyaXB0aW9uIjoiY29sb3I7IGFkZGl0aXZlIGFuZCBzdWJ0cmFjdGl2ZSAoUllCKSBwcmltYXJ5IGNvbG9yOyB2aXNpYmxlIGJldHdlZW4gcHVycGxlIGFuZCBncmVlbiJ9LHsiaWQiOiJRNzY3NjgiLCJuYW1lIjoic2hpcnQiLCJkZXNjcmlwdGlvbiI6Imdhcm1lbnQgZm9yIHRoZSB1cHBlciBib2R5In0seyJpZCI6IlEyMzQ0NjAiLCJuYW1lIjoidGV4dCIsImRlc2NyaXB0aW9uIjoib2JqZWN0IHRoYXQgY2FuIGJlIFxcXCJyZWFkXFxcIiBieSByZWFkZXI7IHJlc3VsdCBvZiB3cml0aW5nIn0seyJpZCI6IlE2NTY3MjAiLCJuYW1lIjoid29ya3Nob3AiLCJkZXNjcmlwdGlvbiI6InJvb20gb3IgYnVpbGRpbmcsIHdpdGggdG9vbHMsIHVzZWQgdG8gcmVwYWlyIG9yIG1ha2UgZ29vZHMifSx7ImlkIjoiUTE1OTg5MjUzIiwibmFtZSI6InBhcnQgb2YiLCJkZXNjcmlwdGlvbiI6InNlcGFyYXRlIGVsZW1lbnQgb2YgYSBsYXJnZXIgKGRpdmlzaWJsZSBvciBpbmRpdmlzaWJsZSkgZW50aXR5In1d"
                    )
                )
            )
        )
    ),
    override val query6: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTExNDI2IiwibmFtZSI6Im1ldGFsIiwiZGVzY3JpcHRpb24iOiJlbGVtZW50LCBjb21wb3VuZCBvciBhbGxveSB0aGF0IGlzIGEgZ29vZCBjb25kdWN0b3Igb2YgYm90aCBlbGVjdHJpY2l0eSBhbmQgaGVhdCJ9LHsiaWQiOiJRNjk1ODc0NyIsIm5hbWUiOiJ3b3JrIiwiZGVzY3JpcHRpb24iOiJwYXJ0aWN1bGFyIGZvcm0gb2YgYWN0aXZpdHksIHNvbGQgYnkgbWFueSBwZW9wbGUgdG8gc3VzdGFpbiB0aGVtc2VsdmVzIn0seyJpZCI6IlExNjIxNTk3IiwibmFtZSI6IldvcmtiZW5jaCIsImRlc2NyaXB0aW9uIjoiIn0seyJpZCI6IlE2NTY3MjAiLCJuYW1lIjoid29ya3Nob3AiLCJkZXNjcmlwdGlvbiI6InJvb20gb3IgYnVpbGRpbmcsIHdpdGggdG9vbHMsIHVzZWQgdG8gcmVwYWlyIG9yIG1ha2UgZ29vZHMifV0="
                    )
                )
            )
        )
    ),
    override val query7: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE4MzQyNzM4IiwibmFtZSI6InB1YmxpYyBzcGVha2luZyIsImRlc2NyaXB0aW9uIjoicHJvY2VzcyBhbmQgYWN0IG9mIHNwZWFraW5nIG9yIGdpdmluZyBhIGxlY3R1cmUgdG8gYSBncm91cCBvZiBwZW9wbGUgaW4gYSBzdHJ1Y3R1cmVkLCBkZWxpYmVyYXRlIG1hbm5lciBpbnRlbmRlZCB0byBpbmZvcm0sIGluZmx1ZW5jZSwgb3IgZW50ZXJ0YWluIGEgbGlzdGVuaW5nIGF1ZGllbmNlIn0seyJpZCI6IlExNzg2NTEiLCJuYW1lIjoiaW50ZXJ2aWV3IiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmVkIHNlcmllcyBvZiBxdWVzdGlvbnMgYW5kIGFuc3dlcnMifV0="
                    )
                )
            )
        )
    ),
    override val query8: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTEyNTM1NiIsIm5hbWUiOiJzYXciLCJkZXNjcmlwdGlvbiI6InRvb2wgdXNlZCB0byBjdXQgdGhyb3VnaCB3b29kIG9yIG90aGVyIG1hdGVyaWFscyJ9LHsiaWQiOiJRMTE0MjYiLCJuYW1lIjoibWV0YWwiLCJkZXNjcmlwdGlvbiI6ImVsZW1lbnQsIGNvbXBvdW5kIG9yIGFsbG95IHRoYXQgaXMgYSBnb29kIGNvbmR1Y3RvciBvZiBib3RoIGVsZWN0cmljaXR5IGFuZCBoZWF0In1d"
                    )
                )
            )
        )
    ),
    override val query9: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTI4NTAzNzUxIiwibmFtZSI6InNwZWFrZXIiLCJkZXNjcmlwdGlvbiI6InBlcnNvbiBjYXBhYmxlIG9mIHZlcmJhbCBjb21tdW5pY2F0aW9uIn0seyJpZCI6IlE5MTM0IiwibmFtZSI6Im15dGhvbG9neSIsImRlc2NyaXB0aW9uIjoic3RvcmllcyBvZiBnb2RzIGFuZCBmYWlyaWVzIGFuZCBmYW50YXN0aWMgY3JlYXR1cmVzIn0seyJpZCI6IlE3MjkiLCJuYW1lIjoiYW5pbWFsIiwiZGVzY3JpcHRpb24iOiJraW5nZG9tIG9mIG11bHRpY2VsbHVsYXIgZXVrYXJ5b3RpYyBvcmdhbmlzbXMifV0="
                    )
                )
            )
        )
    )
) : LargePool()

data class LargePoolTask3(
    override val poolId: String = "03",
    override val result: Result = Result("v_06426", 91f, 111f),
    override val query1: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "Manager"
                    )
                )
            ),
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTE3ODY1MSIsIm5hbWUiOiJpbnRlcnZpZXciLCJkZXNjcmlwdGlvbiI6InN0cnVjdHVyZWQgc2VyaWVzIG9mIHF1ZXN0aW9ucyBhbmQgYW5zd2VycyJ9XQ=="
                    )
                )
            )
        ),
    ),
    override val query2: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTEyNzQ4MyIsIm5hbWUiOiJiaWN5Y2xlIGhlbG1ldCIsImRlc2NyaXB0aW9uIjoiaGVsbWV0IGZvciBwZW9wbGUgb24gYmljeWNsZXMgaW50ZW5kZWQgdG8gcmVkdWNlIGluanVyaWVzIGluIHRoZSBldmVudCBvZiBhIGNvbGxpc2lvbiBvciBjcmFzaCJ9LHsiaWQiOiJRMzYwOSIsIm5hbWUiOiJyb2FkIGJpY3ljbGUgcmFjaW5nIiwiZGVzY3JpcHRpb24iOiJiaWN5Y2xlIHJhY2luZyBzcG9ydCJ9XQ=="
                    )
                )
            )
        )
    ),
    override val query3: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTE0NDIiLCJuYW1lIjoiYmljeWNsZSIsImRlc2NyaXB0aW9uIjoicGVkYWwtZHJpdmVuIHR3by13aGVlbCB2ZWhpY2xlIn0seyJpZCI6IlE3NzE0NTIiLCJuYW1lIjoiYmljeWNsZSB0aXJlIiwiZGVzY3JpcHRpb24iOiJhIHRpcmUgdGhhdCBmaXRzIG9uIHRoZSB3aGVlbCBvZiBhIGJpY3ljbGUifSx7ImlkIjoiUTE2MTk3MyIsIm5hbWUiOiJjdXJ2ZSIsImRlc2NyaXB0aW9uIjoibWF0aGVtYXRpY2FsIGlkZWFsaXphdGlvbiBvZiB0aGUgdHJhY2UgbGVmdCBieSBhIG1vdmluZyBwb2ludCJ9LHsiaWQiOiJRMzQ0NDIiLCJuYW1lIjoicm9hZCIsImRlc2NyaXB0aW9uIjoid2F5IG9uIGxhbmQgYmV0d2VlbiB0d28gcGxhY2VzIn0seyJpZCI6IlE0Mjg4OSIsIm5hbWUiOiJ2ZWhpY2xlIiwiZGVzY3JpcHRpb24iOiJtb2JpbGUgbWFjaGluZSB0aGF0IHRyYW5zcG9ydHMgcGVvcGxlLCBhbmltYWxzIG9yIGNhcmdvIn0seyJpZCI6IlEyMjkzODU3NiIsIm5hbWUiOiJyYWNlIiwiZGVzY3JpcHRpb24iOiJjb21wZXRpdGl2ZSBldmVudCBpbiB3aGljaCBwYXJ0aWNpcGFudHMgYXR0ZW1wdCB0byBjb21wbGV0ZSBvYmplY3RpdmVzIGFzIGZhc3QgYXMgcG9zc2libGUifV0="
                    )
                )
            )
        )
    ),
    override val query4: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRNDY3IiwibmFtZSI6IndvbWFuIiwiZGVzY3JpcHRpb24iOiJmZW1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTQyMTc3IiwibmFtZSI6ImJlZCIsImRlc2NyaXB0aW9uIjoicGllY2Ugb2YgZnVybml0dXJlIHVzZWQgYXMgYSBwbGFjZSB0byBzbGVlcCBvciByZWxheCJ9LHsiaWQiOiJRMTE0NDU5MyIsIm5hbWUiOiJzaXR0aW5nIiwiZGVzY3JpcHRpb24iOiJodW1hbiByZXN0aW5nIHBvc2l0aW9uOyBib2R5IHdlaWdodCBpcyBzdXBwb3J0ZWQgcHJpbWFyaWx5IGJ5IHRoZSBidXR0b2NrcyBpbiBjb250YWN0IHdpdGggdGhlIGdyb3VuZCBvciBhIGhvcml6b250YWwgb2JqZWN0IHN1Y2ggYXMgYSBjaGFpciJ9LHsiaWQiOiJRMTY5MTciLCJuYW1lIjoiaG9zcGl0YWwiLCJkZXNjcmlwdGlvbiI6ImhlYWx0aCBjYXJlIGZhY2lsaXR5IChmb3Igb3JnYW5pemF0aW9ucyB1c2UgIG1lZGljYWwgb3JnYW5pemF0aW9uIChRNDI4Nzc0NSksIGZvciBpbmRpdmlkdWFsIGJ1aWxkaW5ncyB1c2UgUTM5MzY0NzIzKSJ9LHsiaWQiOiJRMzE0MDk3MSIsIm5hbWUiOiJob3NwaXRhbGl6YXRpb24iLCJkZXNjcmlwdGlvbiI6ImFkbWlzc2lvbiBvZiBhIHBhdGllbnQgdG8gYSBob3NwaXRhbCJ9LHsiaWQiOiJRNjU1NDEwMSIsIm5hbWUiOiJtZWRpY2FsIGRldmljZSIsImRlc2NyaXB0aW9uIjoiYW55IGluc3RydW1lbnQsIGFwcGFyYXR1cywgaW1wbGFudCwgaW4gdml0cm8gcmVhZ2VudCwgb3Igc2ltaWxhciBvciByZWxhdGVkIGFydGljbGUgdXNlZCBmb3IgZGlhZ25vc3RpYyBhbmQvb3IgdGhlcmFwZXV0aWMgcHVycG9zZXMifSx7ImlkIjoiUTI2Mzc4MTQiLCJuYW1lIjoicmFjayBvZiBzaGVsdmVzIiwiZGVzY3JpcHRpb24iOiJzZXQgb2Ygc2hlbHZlcywgY29tYmluZWQgaW50byBvbmUgcGllY2Ugb2YgZnVybml0dXJlIn1d"
                    )
                )
            )
        )
    ),
    override val query5: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRODQ0MSIsIm5hbWUiOiJtYW4iLCJkZXNjcmlwdGlvbiI6Im1hbGUgYWR1bHQgaHVtYW4ifSx7ImlkIjoiUTIzMzMyMCIsIm5hbWUiOiJzY2FmZm9sZCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IHN0cnVjdHVyZSB1c2VkIHRvIHN1cHBvcnQgYSB3b3JrIGNyZXcgYW5kIG1hdGVyaWFscyJ9LHsiaWQiOiJRNDIzMDIiLCJuYW1lIjoiY2xheSIsImRlc2NyaXB0aW9uIjoic29mdCByb2NrIGJhc2VkIGNvbXBvdW5kIG9mdGVuIHVzZWQgZm9yIHNjdWxwdHVyZSBhbmQgdG9vbHMifV0="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "reconstructed"
                    )
                )
            )
        )
    ),
    override val query6: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMzcwMTciLCJuYW1lIjoiZmFjZSIsImRlc2NyaXB0aW9uIjoicGFydCBvZiB0aGUgYm9keSBhdCB0aGUgZnJvbnQgb2YgdGhlIGhlYWQifV0="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "by traditional material"
                    )
                )
            )
        )
    ),
    override val query7: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTI1MTQwMyIsIm5hbWUiOiJhbGxleSIsImRlc2NyaXB0aW9uIjoibmFycm93IHN0cmVldCJ9LHsiaWQiOiJRNjUzNzM3OSIsIm5hbWUiOiJ3YWxraW5nIiwiZGVzY3JpcHRpb24iOiJvbmUgb2YgdGhlIG1haW4gZ2FpdHMgb2YgbG9jb21vdGlvbiBhbW9uZyBsZWdnZWQgYW5pbWFscywgdHlwaWNhbGx5IHNsb3dlciB0aGFuIHJ1bm5pbmcgYW5kIG90aGVyIGdhaXRzOyBjaGFyYWN0ZXJpemVkIGJ5IGEgJ3ZhdWx0aW5nJyBtb3ZlbWVudCBvZiB0aGUgYm9keSBvdmVyIHRoZSBsZWdzLCBmcmVxdWVudGx5IGRlc2NyaWJlZCBhcyBhbiBpbnZlcnRlZCBwZW5kdWx1bSJ9LHsiaWQiOiJRMjE1NjI3IiwibmFtZSI6InBlcnNvbiIsImRlc2NyaXB0aW9uIjoiYmVpbmcgdGhhdCBoYXMgY2VydGFpbiBjYXBhY2l0aWVzIG9yIGF0dHJpYnV0ZXMgY29uc3RpdHV0aW5nIHBlcnNvbmhvb2QgKGF2b2lkIHVzZSB3aXRoIFAzMTsgdXNlIFE1IGZvciBodW1hbnMpIn1d"
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.OCR),
                        "I follow him through the streets,"
                    )
                )
            )
        )
    ),
    override val query8: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTIyODAiLCJuYW1lIjoiYnJpZGdlIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUgYnVpbHQgdG8gc3BhbiBwaHlzaWNhbCBvYnN0YWNsZXMifSx7ImlkIjoiUTE3NTMzNCIsIm5hbWUiOiJ3aGVlbGJhcnJvdyIsImRlc2NyaXB0aW9uIjoic21hbGwgaGFuZC1wcm9wZWxsZWQgdmVoaWNsZSJ9XQ=="
                    ),
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.ASR),
                        "middle"
                    )
                )
            )
        )
    ),
    override val query9: Query = Query(
        listOf(
            QueryContainer(
                listOf(
                    Term(
                        VBSCategories.text,
                        listOf(VBSTypes.concept),
                        "data:application/json;base64,W3siaWQiOiJRMTQ5NzM2NCIsIm5hbWUiOiJidWlsZGluZyBjb21wbGV4IiwiZGVzY3JpcHRpb24iOiJzZXQgb2YgcmVsYXRlZCBidWlsZGluZ3MifSx7ImlkIjoiUTQxMTc2IiwibmFtZSI6ImJ1aWxkaW5nIiwiZGVzY3JpcHRpb24iOiJzdHJ1Y3R1cmUsIHR5cGljYWxseSB3aXRoIGEgcm9vZiBhbmQgd2FsbHMsIHN0YW5kaW5nIG1vcmUgb3IgbGVzcyBwZXJtYW5lbnRseSBpbiBvbmUgcGxhY2UifSx7ImlkIjoiUTIzMzMyMCIsIm5hbWUiOiJzY2FmZm9sZCIsImRlc2NyaXB0aW9uIjoidGVtcG9yYXJ5IHN0cnVjdHVyZSB1c2VkIHRvIHN1cHBvcnQgYSB3b3JrIGNyZXcgYW5kIG1hdGVyaWFscyJ9LHsiaWQiOiJRMTY1MzIyNzYiLCJuYW1lIjoid29yayIsImRlc2NyaXB0aW9uIjoiYWN0aXZpdHkgZG9uZSBieSBhIHBlcnNvbiB0byBlYXJuIGEgbGl2aW5nIn0seyJpZCI6IlEzODc1MTg2IiwibmFtZSI6ImNvbnN0cnVjdGlvbiIsImRlc2NyaXB0aW9uIjoicHJvY2VzcyBvZiBidWlsZGluZyJ9XQ=="
                    )
                )
            )
        )
    )
) : LargePool()
